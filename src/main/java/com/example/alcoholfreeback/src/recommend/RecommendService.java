package com.example.alcoholfreeback.src.recommend;

import com.example.alcoholfreeback.common.exceptions.BaseException;
import com.example.alcoholfreeback.common.response.BaseResponseStatus;
import com.example.alcoholfreeback.src.recommend.entity.Recommend;
import com.example.alcoholfreeback.src.recommend.model.*;

import lombok.RequiredArgsConstructor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
@Transactional
public class RecommendService {
    private RecommendRepository recommendRepository;
    private static final RestTemplate restTemplate = new RestTemplate();

    @Value("${chatgpt.api-key}")
    private String token;

    @Autowired
    public RecommendService(RecommendRepository recommendRepository) {
        this.recommendRepository = recommendRepository;
    }

    public HttpEntity<ChatGPTReq> buildHttpEntity(ChatGPTReq req) {
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.parseMediaType("application/json; charset=UTF-8"));
        headers.add("Authorization", "Bearer " + token);
        return new HttpEntity<>(req, headers);
    }

    public ChatGPTRes getResponse(HttpEntity<ChatGPTReq> chatGPTReqHttpEntity) {
        ResponseEntity<ChatGPTRes> responseEntity = restTemplate.postForEntity(
                "https://api.openai.com/v1/chat/completions",
                chatGPTReqHttpEntity,
                ChatGPTRes.class
        );
        return responseEntity.getBody();
    }

    public PostRecommendRes postRecommend(PostRecommendReq recommendReq) {
        String question = "Please explain the recipe of cocktail in korean that can be made with the following ingredients ```"+recommendReq.getIngredients().toString()+"``` in 500 characters";
        List<Message> messages = new ArrayList<Message>();
        messages.add(new Message("assistant", question));
        String name = String.join(" ", recommendReq.getIngredients()) + " 칵테일";
        Choice choice = (Choice) this.getResponse(
                this.buildHttpEntity(
                        new ChatGPTReq(
                                "gpt-3.5-turbo",
                                messages,
                                0.7
                        )
                )
        ).getChoices().get(0);

        String description =  choice.getMessage().getContent();

        Recommend recommend = new Recommend(name, description);
        Long id = recommendRepository.save(recommend).getId();

        return new PostRecommendRes(id, name, description);
    }

    public List<RecommendDto> getRecommendRecipes() {
        List<Recommend> recipes = recommendRepository.findAll();
        if (recipes.isEmpty()) {
            return Collections.emptyList();
        }
        return recipes.stream().map(RecommendDto::new).collect(Collectors.toList());
    }

    public List<RecommendDto> getMyRecommends(MyRecommendDto myRecommendDto) {
        List<Recommend> recommends = recommendRepository.findAllById(myRecommendDto.getRecommendIds());
        if (recommends.isEmpty()) {
            return Collections.emptyList();
        }
        return recommends.stream().map(RecommendDto::new).collect(Collectors.toList());
    }

    public PostRecommendRes getRecommend(Long id) {
        Recommend recommend = recommendRepository.findById(id).orElseThrow(
                () -> new BaseException(BaseResponseStatus.SERVER_ERROR));
        return new PostRecommendRes(recommend);
    }
}

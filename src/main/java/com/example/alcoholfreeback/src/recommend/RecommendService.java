package com.example.alcoholfreeback.src.recommend;

import com.example.alcoholfreeback.common.exceptions.BaseException;
import com.example.alcoholfreeback.common.response.BaseResponseStatus;
import com.example.alcoholfreeback.src.recommend.entity.Recommend;
import com.example.alcoholfreeback.src.recommend.model.MyRecommendDto;
import com.example.alcoholfreeback.src.recommend.model.PostRecommendReq;
import com.example.alcoholfreeback.src.recommend.model.PostRecommendRes;

import com.example.alcoholfreeback.src.recommend.model.RecommendDto;
import lombok.RequiredArgsConstructor;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
@Transactional
public class RecommendService {
    private RecommendRepository recommendRepository;

    @Value("${chatgpt.api-key}")
    private String token;

    @Autowired
    public RecommendService(RecommendRepository recommendRepository) {
        this.recommendRepository = recommendRepository;
    }

    public PostRecommendRes postRecommend(PostRecommendReq recommendReq) {

        HttpURLConnection connection = null;
        String parameters = "{\"model\": \"gpt-3.5-turbo\", " +
                "\"messages\": [{\"role\": \"user\", " +
                    "\"content\": \"Please explain the recipe of cocktail in korean that can be made with the following ingredients ```"+recommendReq.getIngredients().toString()+"``` in 500 characters\"" +
                "}], " +
                    "\"temperature\": 0.7\n" +
                "}";

        try {
            //Create connection
            URL url = new URL("https://api.openai.com/v1/chat/completions");
            connection = (HttpURLConnection) url.openConnection();
            // 요청 메소드에 따라서 GET,DELETE, PUT 등으로 변경하시면 됩니다.
            connection.setRequestMethod("POST");
            //Content-Type 또한 요청 받는 데이터 타입이 Json이면 json타입으로 선언해주시면 되고
            // 개발 환경에 따라 설정해주시면 됩니다.
            connection.setRequestProperty("Content-Type",
                    "application/json");
            connection.setRequestProperty("Authorization",
                    "Bearer "+token);
            connection.setRequestProperty("Accept", "application/json");

            connection.setUseCaches(false);// 캐싱데이터를 받을지 말지 세팅합니다.
            connection.setDoOutput(true); // 쓰기모드를 지정할지 세팅합니다.

            try (OutputStream os = connection.getOutputStream()){
                byte request_data[] = parameters.getBytes("utf-8");
                os.write(request_data);
                os.close();
            }
            catch(Exception e) {
                e.printStackTrace();
            }

            //http 요청 실시
            connection.connect();

            //http 요청 후 응답 받은 데이터를 버퍼에 쌓는다
            BufferedReader br = new BufferedReader(new InputStreamReader(connection.getInputStream(), "UTF-8"));
            StringBuffer sb = new StringBuffer();
            String responseData;
            while ((responseData = br.readLine()) != null) {
                sb.append(responseData); //StringBuffer에 응답받은 데이터 순차적으로 저장 실시
            }

            //메소드 호출 완료 시 반환하는 변수에 버퍼 데이터 삽입 실시
            String returnData = sb.toString();
            JSONParser jsonParser = new JSONParser();
            JSONObject jsonObject = (JSONObject) jsonParser.parse(returnData);
            String description = (String) ((JSONObject) ((JSONObject) ((JSONArray) jsonObject.get("choices")).get(0)).get("message")).get("content");

            String name = String.join(" ", recommendReq.getIngredients()) + " 칵테일";

            Recommend recommend = new Recommend(name, description);
            Long id = recommendRepository.save(recommend).getId();

            return new PostRecommendRes(id, name, description);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        } finally {
            if (connection != null) {
                // 에러와 관계없이 모든 로직이 끝나면 connection 객체 (HttpURLConnection)를
                // disconnect 하여 모든 연결을 종료합니다.
                connection.disconnect();
            }
        }
    }

    public List<RecommendDto> getRecommendRecipes() {
        List<Recommend> recipes = recommendRepository.findAll();
        if (recipes == null || recipes.isEmpty()) {
            return Collections.emptyList();
        }
        return recipes.stream().map(RecommendDto::new).collect(Collectors.toList());
    }

    public List<RecommendDto> getMyRecommends(MyRecommendDto myRecommendDto) {
        List<Recommend> recommends = recommendRepository.findAllById(myRecommendDto.getRecommendIds());
        if (recommends == null || recommends.isEmpty()) {
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

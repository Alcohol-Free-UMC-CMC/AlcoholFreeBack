package com.example.alcoholfreeback.src.recommend;

import com.example.alcoholfreeback.common.exceptions.BaseException;
import com.example.alcoholfreeback.common.response.BaseResponse;
import com.example.alcoholfreeback.src.recommend.model.PostRecommendReq;
import com.example.alcoholfreeback.src.recommend.model.PostRecommendRes;
import io.swagger.v3.oas.annotations.Operation;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class RecommendController {

    private RecommendService recommendService;

    @Autowired
    public RecommendController(RecommendService recommendService) {
        this.recommendService = recommendService;
    }

    @PostMapping("recommend")
    public BaseResponse<PostRecommendRes> postRecommend(@RequestBody PostRecommendReq recommendReq) {
        try{
            PostRecommendRes result = recommendService.postRecommend(recommendReq);
            return new BaseResponse<>(result);
        }catch(BaseException e) {
            return new BaseResponse<>(e.getStatus());
        }
    }

}

package com.example.alcoholfreeback.src.recommend;

import com.example.alcoholfreeback.common.exceptions.BaseException;
import com.example.alcoholfreeback.common.response.BaseResponse;
import com.example.alcoholfreeback.src.recommend.model.PostRecommendReq;
import com.example.alcoholfreeback.src.recommend.model.PostRecommendRes;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@Api(tags = {"재료 기반 칵테일 추천 API"})
public class RecommendController {

    private RecommendService recommendService;

    @Autowired
    public RecommendController(RecommendService recommendService) {
        this.recommendService = recommendService;
    }

    @ApiOperation(
            value = "재료 키워드 기반 추천 칵테일 요청",
            notes = "chatAPI를 통해 추천 칵테일 정보 반환"
    )
    @PostMapping("app/recommend")
    public BaseResponse<PostRecommendRes> postRecommend(@RequestBody PostRecommendReq recommendReq) {
        try{
            PostRecommendRes result = recommendService.postRecommend(recommendReq);
            return new BaseResponse<>(result);
        }catch(BaseException e) {
            return new BaseResponse<>(e.getStatus());
        }
    }

}

package com.example.alcoholfreeback.src.recommend;

import com.example.alcoholfreeback.common.exceptions.BaseException;
import com.example.alcoholfreeback.common.response.BaseResponse;
import com.example.alcoholfreeback.src.recommend.model.MyRecommendDto;
import com.example.alcoholfreeback.src.recommend.model.PostRecommendReq;
import com.example.alcoholfreeback.src.recommend.model.PostRecommendRes;
import com.example.alcoholfreeback.src.recommend.model.RecommendDto;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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

    @ApiOperation(
            value = "chatAPI를 추천 받은 칵테일 리스트 반환",
            notes = "chatAPI를 추천 받은 칵테일 리스트 반환"
    )
    @GetMapping("app/recommend/list")
    public BaseResponse<List<RecommendDto>> getRecommendRecipes() {
        try{
            List<RecommendDto> result = recommendService.getRecommendRecipes();
            return new BaseResponse<>(result);
        }catch(BaseException e) {
            return new BaseResponse<>(e.getStatus());
        }
    }

    @ApiOperation(
            value = "chatAPI를 추천 받은 칵테일 리스트 반환",
            notes = "chatAPI를 추천 받은 칵테일 리스트 반환"
    )
    @PostMapping("app/recommend/like")
    public BaseResponse<List<RecommendDto>> getMyRecommends(@RequestBody MyRecommendDto myRecommendDto) {
        try{
            List<RecommendDto> result = recommendService.getMyRecommends(myRecommendDto);
            return new BaseResponse<>(result);
        }catch(BaseException e) {
            return new BaseResponse<>(e.getStatus());
        }
    }

    @ApiOperation(
            value = "chatAPI를 추천 받은 특정 칵테일을 반환",
            notes = "chatAPI를 추천 받은 특정 칵테일을 반환"
    )
    @GetMapping("app/recommend/{recommend_id}")
    public BaseResponse<PostRecommendRes> getMyRecommends(@PathVariable("recommend_id") Long id) {
        try{
            PostRecommendRes result = recommendService.getRecommend(id);
            return new BaseResponse<>(result);
        }catch(BaseException e) {
            return new BaseResponse<>(e.getStatus());
        }
    }
}

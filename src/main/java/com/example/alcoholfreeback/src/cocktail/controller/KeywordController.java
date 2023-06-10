package com.example.alcoholfreeback.src.cocktail.controller;


import com.example.alcoholfreeback.common.response.BaseResponse;
import com.example.alcoholfreeback.src.cocktail.dto.IngredientNameResponseDto;
import com.example.alcoholfreeback.src.cocktail.dto.TagNameResponseDto;
import com.example.alcoholfreeback.src.cocktail.service.IngredientService;
import com.example.alcoholfreeback.src.cocktail.service.TagService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@Api(tags = {"키워드 조회 API"})
@RequestMapping("/app/keyword")
public class KeywordController {
    private final TagService tagService;
    private final IngredientService ingredientService;

    @ApiOperation(
            value = "전체 태그 조회",
            notes = "태그 기반 검색을 위한 태그 리스트 조회"
    )
    @GetMapping("/tags")
    public BaseResponse<List<TagNameResponseDto>> getTagNameList() {
        List<TagNameResponseDto> responseDtos = tagService.allTags();
        return new BaseResponse(responseDtos);
    }

    @ApiOperation(
            value = "전체 재료 조회",
            notes = "재료 기반 검색을 위한 재료 리스트 조회"
    )
    @GetMapping("/ingredients")
    public BaseResponse<List<IngredientNameResponseDto>> getIngredientNameList() {
        List<IngredientNameResponseDto> responseDtos = ingredientService.allIngredients();
        return new BaseResponse(responseDtos);
    }
}

package com.example.alcoholfreeback.src.cocktail.controller;


import com.example.alcoholfreeback.common.exceptions.BaseException;
import com.example.alcoholfreeback.common.response.BaseResponse;
import com.example.alcoholfreeback.src.cocktail.dto.IngredientNameResponseDto;
import com.example.alcoholfreeback.src.cocktail.dto.TagNameResponseDto;
import com.example.alcoholfreeback.src.cocktail.service.IngredientService;
import com.example.alcoholfreeback.src.cocktail.service.TagService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/app/keyword")
public class KeywordController {
    private final TagService tagService;
    private final IngredientService ingredientService;

    @GetMapping("/tags")
    public BaseResponse<List<TagNameResponseDto>> getTagNameList() {
        try {
            List<TagNameResponseDto> responseDtos = tagService.allTags();
            return new BaseResponse(responseDtos);
        } catch (BaseException baseException) {
            return new BaseResponse<>(baseException.getStatus());
        }
    }

    @GetMapping("/ingredients")
    public BaseResponse<List<IngredientNameResponseDto>> getIngredientNameList() {
        try {
            List<IngredientNameResponseDto> responseDtos = ingredientService.allIngredients();
            return new BaseResponse(responseDtos);
        } catch (BaseException baseException) {
            return new BaseResponse<>(baseException.getStatus());
        }
    }
}

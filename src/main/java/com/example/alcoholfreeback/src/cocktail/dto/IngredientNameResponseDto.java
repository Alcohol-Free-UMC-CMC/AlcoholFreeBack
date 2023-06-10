package com.example.alcoholfreeback.src.cocktail.dto;

import com.example.alcoholfreeback.src.cocktail.entity.Ingredient;
import lombok.Builder;

public class IngredientNameResponseDto {
    private String name;

    @Builder
    private IngredientNameResponseDto(String name) {
        this.name = name;
    }

    public static IngredientNameResponseDto from(Ingredient ingredient) {
        return IngredientNameResponseDto.builder()
                .name(ingredient.getName())
                .build();
    }
}

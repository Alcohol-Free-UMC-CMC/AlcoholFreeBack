package com.example.alcoholfreeback.src.guide.dto;

import com.example.alcoholfreeback.src.cocktail.entity.Ingredient;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class IngredientResponseDto {
    private Long id;
    private String name;
    private String description;
    private String imgUrl;

    @Builder
    private IngredientResponseDto(Long id, String name, String description, String imgUrl){
        this.id = id;
        this.name = name;
        this.description = description;
        this.imgUrl = imgUrl;
    }

    public static IngredientResponseDto from(Ingredient ingredient){
        return IngredientResponseDto.builder()
                .id(ingredient.getId())
                .name(ingredient.getName())
                .description(ingredient.getDescription())
                .imgUrl(ingredient.getImgUrl())
                .build();
    }
}

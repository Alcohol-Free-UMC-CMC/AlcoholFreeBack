package com.example.alcoholfreeback.src.cocktail.model;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
public class CocktailDetailDto {

    private String name;
    private String imageUrl;
    private String description;
    private List<String> tags;
    private List<IngredientDto> ingredients;
    private String recipe;

    public CocktailDetailDto(String name, String imageUrl, String description, List<String> tags, List<IngredientDto> ingredients, String recipe) {
        this.name = name;
        this.imageUrl = imageUrl;
        this.description = description;
        this.tags = tags;
        this.ingredients = ingredients;
        this.recipe = recipe;
    }
}

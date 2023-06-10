package com.example.alcoholfreeback.src.cocktail.model;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class CocktailSearchCond {

    private String keyword;
    private String tag;
    private String ingredient;

    public CocktailSearchCond(String keyword, String tag, String ingredient) {
        this.keyword = keyword;
        this.tag = tag;
        this.ingredient = ingredient;
    }
}

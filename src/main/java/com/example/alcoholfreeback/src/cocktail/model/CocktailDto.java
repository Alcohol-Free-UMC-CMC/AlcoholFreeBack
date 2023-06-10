package com.example.alcoholfreeback.src.cocktail.model;

import com.example.alcoholfreeback.src.cocktail.entity.Cocktail;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class CocktailDto {

    private Long id;
    private String imageUrl;
    private String name;

    public CocktailDto(Cocktail cocktail) {
        this.id = cocktail.getId();
        this.imageUrl = cocktail.getImageUrl();
        this.name = cocktail.getName();
    }
}

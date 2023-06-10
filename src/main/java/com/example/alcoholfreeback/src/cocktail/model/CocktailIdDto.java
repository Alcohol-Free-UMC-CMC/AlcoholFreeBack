package com.example.alcoholfreeback.src.cocktail.model;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
public class CocktailIdDto {

    private List<Long> cocktailIds;

    public CocktailIdDto(List<Long> cocktailIds) {
        this.cocktailIds = cocktailIds;
    }
}

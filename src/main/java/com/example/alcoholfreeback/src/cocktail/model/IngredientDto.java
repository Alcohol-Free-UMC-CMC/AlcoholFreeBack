package com.example.alcoholfreeback.src.cocktail.model;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class IngredientDto {

    private String name;
    private String amount;

    public IngredientDto(String name, String amount) {
        this.name = name;
        this.amount = amount;
    }
}

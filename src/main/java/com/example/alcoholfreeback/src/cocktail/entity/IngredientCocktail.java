package com.example.alcoholfreeback.src.cocktail.entity;

import com.example.alcoholfreeback.common.entity.BaseEntity;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
@Entity
public class IngredientCocktail extends BaseEntity {

    @Id @GeneratedValue
    @Column(name = "ingredient_cocktail_id")
    private Long id;
    private String amount;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "ingredient_id")
    private Ingredient ingredient;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "cocktail_id")
    private Cocktail cocktail;

    public IngredientCocktail(Ingredient ingredient, Cocktail cocktail, String amount) {
        this.ingredient = ingredient;
        this.cocktail = cocktail;
        this.amount = amount;
    }
}

package com.example.alcoholfreeback.src.cocktail.entity;

import com.example.alcoholfreeback.common.entity.BaseEntity;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
@Entity
public class Ingredient extends BaseEntity {

    @Id @GeneratedValue
    @Column(name = "ingredient_id")
    private Long id;
    private String name;

    @OneToMany(mappedBy = "ingredient", fetch = FetchType.LAZY)
    private List<IngredientCocktail> cocktails = new ArrayList<>();

    public Ingredient(String name, List<IngredientCocktail> cocktails) {
        this.name = name;
        this.cocktails = cocktails;
    }
}

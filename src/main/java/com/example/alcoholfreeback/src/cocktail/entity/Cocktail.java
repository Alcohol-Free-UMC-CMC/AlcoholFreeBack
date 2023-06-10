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
public class Cocktail extends BaseEntity {

    @Id @GeneratedValue
    @Column(name = "cocktail_id")
    private Long id;
    private String name;
    private String recipe;
    private String imageUrl;

    @OneToMany(mappedBy = "cocktail", fetch = FetchType.LAZY)
    private List<IngredientCocktail> ingredients = new ArrayList<>();

    @OneToMany(mappedBy = "cocktail", fetch = FetchType.LAZY)
    private List<CocktailTag> tags = new ArrayList<>();

    public Cocktail(String recipe, String imageUrl) {
        this.recipe = recipe;
        this.imageUrl = imageUrl;
    }
}

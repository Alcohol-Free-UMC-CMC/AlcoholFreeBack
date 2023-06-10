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
    private String description;
    private String recipe;
    private String imageUrl;
    private Long views;

    @OneToMany(mappedBy = "cocktail", fetch = FetchType.LAZY, cascade = CascadeType.PERSIST)
    private List<IngredientCocktail> ingredients = new ArrayList<>();

    @OneToMany(mappedBy = "cocktail", fetch = FetchType.LAZY, cascade = CascadeType.PERSIST)
    private List<CocktailTag> tags = new ArrayList<>();

    public Cocktail(String name, String description, String recipe, String imageUrl) {
        this.name = name;
        this.description = description;
        this.recipe = recipe;
        this.imageUrl = imageUrl;
        this.views = 0l;
    }

    public void plusViews() {
        this.views += 1;
    }
}

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
public class Tag extends BaseEntity {

    private enum Category {
        FLAVOR, COLOR, MOOD;
    }

    @Id
    @GeneratedValue
    @Column(name = "tag_id")
    private Long id;

    @Enumerated(EnumType.STRING)
    private Category category;

    private String name;

    @OneToMany(mappedBy = "tag", fetch = FetchType.LAZY)
    private List<CocktailTag> cocktails = new ArrayList<>();

    public Tag(Category category, String name, List<CocktailTag> cocktails) {
        this.category = category;
        this.name = name;
        this.cocktails = cocktails;
    }
}

package com.example.alcoholfreeback.src.cocktail.entity;

import com.example.alcoholfreeback.common.entity.BaseEntity;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
@Entity
public class CocktailTag extends BaseEntity {

    @Id @GeneratedValue
    @Column(name = "cocktail_tag_id")
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @Column(name = "cocktail_id")
    private Cocktail cocktail;

    @ManyToOne(fetch = FetchType.LAZY)
    @Column(name = "tag_id")
    private Tag tag;

    public CocktailTag(Cocktail cocktail, Tag tag) {
        this.cocktail = cocktail;
        this.tag = tag;
    }
}

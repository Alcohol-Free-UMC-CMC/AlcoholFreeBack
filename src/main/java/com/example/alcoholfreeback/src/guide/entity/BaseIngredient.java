package com.example.alcoholfreeback.src.guide.entity;

import com.example.alcoholfreeback.common.entity.BaseEntity;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
@Entity
public class BaseIngredient extends BaseEntity {

    @Id
    @GeneratedValue
    @Column(name = "ingredient_id")
    private Long id;
    private String name;
    @Column(length = 1000)
    private String description;
    private String imgUrl;

    public BaseIngredient(String name, String description, String imgUrl) {
        this.name = name;
        this.description = description;
        this.imgUrl = imgUrl;
    }
}

package com.example.alcoholfreeback.src.recommend.entity;

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
public class Recommend extends BaseEntity {

    @Id @GeneratedValue
    @Column(name = "recommend_id")
    private Long id;
    private String name;
    @Column(length = 1000)
    private String description;

    public Recommend(String name, String description) {
        this.name = name;
        this.description = description;
    }
}

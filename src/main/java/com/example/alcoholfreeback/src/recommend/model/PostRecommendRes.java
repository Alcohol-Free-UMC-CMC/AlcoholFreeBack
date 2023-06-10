package com.example.alcoholfreeback.src.recommend.model;

import com.example.alcoholfreeback.src.recommend.entity.Recommend;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class PostRecommendRes {

    private Long id;
    private String name;
    private String description;

    public PostRecommendRes(Recommend recommend) {
        this.id = recommend.getId();
        this.name = recommend.getName();
        this.description = recommend.getDescription();
    }
}

package com.example.alcoholfreeback.src.recommend.model;

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
}

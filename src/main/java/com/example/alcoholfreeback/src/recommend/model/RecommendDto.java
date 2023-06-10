package com.example.alcoholfreeback.src.recommend.model;

import com.example.alcoholfreeback.src.recommend.entity.Recommend;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class RecommendDto {

    private String name;
    private Long id;

    public RecommendDto(Recommend recommend) {
        this.name = recommend.getName();
        this.id = recommend.getId();
    }
}

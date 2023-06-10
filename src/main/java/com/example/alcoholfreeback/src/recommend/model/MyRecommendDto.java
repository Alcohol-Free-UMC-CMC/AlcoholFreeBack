package com.example.alcoholfreeback.src.recommend.model;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
public class MyRecommendDto {

    List<Long> recommendIds;

    public MyRecommendDto(List<Long> recommendIds) {
        this.recommendIds = recommendIds;
    }
}

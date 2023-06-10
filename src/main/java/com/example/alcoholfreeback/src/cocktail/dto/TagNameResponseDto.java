package com.example.alcoholfreeback.src.cocktail.dto;

import com.example.alcoholfreeback.src.cocktail.entity.Tag;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class TagNameResponseDto {
    private String name;

    @Builder
    private TagNameResponseDto(String name) {
        this.name = name;
    }

    public static TagNameResponseDto from(Tag tag) {
        return TagNameResponseDto.builder()
                .name(tag.getName())
                .build();
    }
}

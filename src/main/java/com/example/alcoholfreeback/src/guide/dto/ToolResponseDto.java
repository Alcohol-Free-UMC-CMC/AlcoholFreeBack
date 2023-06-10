package com.example.alcoholfreeback.src.guide.dto;

import com.example.alcoholfreeback.src.guide.entity.Tool;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class ToolResponseDto {
    private Long id;
    private String name;
    private String description;
    private String imgUrl;

    @Builder
    private ToolResponseDto(Long id, String name, String description, String imgUrl){
        this.id = id;
        this.name = name;
        this.description = description;
        this.imgUrl = imgUrl;
    }

    public static ToolResponseDto from(Tool tool){
        return ToolResponseDto.builder()
                .id(tool.getId())
                .name(tool.getName())
                .description(tool.getDescription())
                .imgUrl(tool.getImgUrl())
                .build();
    }
}

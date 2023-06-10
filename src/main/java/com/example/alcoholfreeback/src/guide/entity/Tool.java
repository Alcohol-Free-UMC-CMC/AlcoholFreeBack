package com.example.alcoholfreeback.src.guide.entity;

import com.example.alcoholfreeback.common.entity.BaseEntity;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
@Entity
public class Tool extends BaseEntity {

    @Id @GeneratedValue
    @Column(name = "tool_id")
    private Long id;
    private String name;
    private String description;
    private String imgUrl;

    public Tool(String name, String description, String imgUrl) {
        this.name = name;
        this.description = description;
        this.imgUrl = imgUrl;
    }
}

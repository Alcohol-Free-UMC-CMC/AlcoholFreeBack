package com.example.alcoholfreeback.src.tool.entity;

import com.example.alcoholfreeback.common.entity.BaseEntity;
import lombok.AccessLevel;
import lombok.EqualsAndHashCode;
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
    private String description;

    public Tool(String description) {
        this.description = description;
    }
}

package com.example.alcoholfreeback.src.recommend.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Getter
@NoArgsConstructor
public class Message implements Serializable {
    @JsonProperty("role")
    private String role;
    @JsonProperty("content")
    private String content;

    @Builder
    public Message(String role, String content) {
        this.role = role;
        this.content = content;
    }
}

package com.example.alcoholfreeback.src.recommend.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.List;

@Getter
@NoArgsConstructor
public class ChatGPTReq implements Serializable {
    private String model;
    private List<Message> messages;
    private Double temperature;

    public ChatGPTReq(String model, List<Message> messages, Double temperature) {
        this.model = model;
        this.messages = messages;
        this.temperature = temperature;
    }
}

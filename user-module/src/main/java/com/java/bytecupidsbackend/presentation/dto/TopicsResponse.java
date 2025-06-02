package com.java.bytecupidsbackend.presentation.dto;

import com.java.bytecupidsbackend.domain.model.SubTopic;

import java.util.List;

public class TopicsResponse {
    private List<SubTopic> topics;
    private String message;
    private String timestamp;
    private Integer code;
    private Boolean success;

    public TopicsResponse() {}

    public TopicsResponse(List<SubTopic> topics, String message, String timestamp, Integer code, Boolean success) {
        this.topics = topics;
        this.message = message;

        this.timestamp = timestamp;
        this.code = code;
        this.success = success;
    }

    public List<SubTopic> getTopics() {
        return topics;
    }

    public void setTopics(List<SubTopic> topics) {
        this.topics = topics;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(String timestamp) {
        this.timestamp = timestamp;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public Boolean getSuccess() {
        return success;
    }

    public void setSuccess(Boolean success) {
        this.success = success;
    }
}

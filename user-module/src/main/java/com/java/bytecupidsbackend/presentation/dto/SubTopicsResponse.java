package com.java.bytecupidsbackend.presentation.dto;

import com.java.bytecupidsbackend.domain.model.SubTopic;

import java.util.List;

public class SubTopicsResponse {
    private List<SubTopic> subtopics;
    private String message;
    private String timestamp;
    private Integer code;
    private Boolean success;

    public SubTopicsResponse() {}

    public SubTopicsResponse(List<SubTopic> subtopics, String message, String timestamp, Integer code, Boolean success) {
        this.subtopics = subtopics;
        this.message = message;

        this.timestamp = timestamp;
        this.code = code;
        this.success = success;
    }

    public List<SubTopic> getSubTopics() {
        return subtopics;
    }

    public void setSubTopics(List<SubTopic> subtopics) {
        this.subtopics = subtopics;
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

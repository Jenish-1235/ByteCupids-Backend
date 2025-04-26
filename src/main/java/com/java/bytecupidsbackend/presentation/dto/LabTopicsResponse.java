package com.java.bytecupidsbackend.presentation.dto;

import com.java.bytecupidsbackend.domain.model.Topic;

import java.util.List;

public class LabTopicsResponse {
    private List<Topic> topics;
    private String message;
    private String status;
    private String error;
    private String timestamp;
    private Integer code;
    private Boolean success;

    public LabTopicsResponse() {}

    public LabTopicsResponse(List<Topic> topics, String message, String status, String error, String timestamp, Integer code, Boolean success) {
        this.topics = topics;
        this.message = message;
        this.status = status;
        this.error = error;
        this.timestamp = timestamp;
        this.code = code;
        this.success = success;
    }

    public List<Topic> getTopics() {
        return topics;
    }

    public void setTopics(List<Topic> topics) {
        this.topics = topics;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getError() {
        return error;
    }

    public void setError(String error) {
        this.error = error;
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

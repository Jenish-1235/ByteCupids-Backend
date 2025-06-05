package com.java.bytecupidsbackend.presentation.dto;

public class SubTopicDeleteResponse {
    private String message;
    private Boolean success;
    private Integer code;
    private String timestamp;

    public SubTopicDeleteResponse(String message, Boolean success, Integer code, String timestamp) {
        this.message = message;
        this.success = success;
        this.code = code;
        this.timestamp = timestamp;
    }

    public SubTopicDeleteResponse() {

    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Boolean getSuccess() {
        return success;
    }

    public void setSuccess(Boolean success) {
        this.success = success;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(String timestamp) {
        this.timestamp = timestamp;
    }
}

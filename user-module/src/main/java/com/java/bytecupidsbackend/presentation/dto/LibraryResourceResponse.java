package com.java.bytecupidsbackend.presentation.dto;

import com.java.bytecupidsbackend.domain.model.LibraryResource;

import java.util.List;

public class LibraryResourceResponse {
    private List<LibraryResource> resources;
    private String message;
    private String status;
    private String error;
    private String timestamp;
    private Integer code;
    private Boolean success;

    public LibraryResourceResponse() {}

    public LibraryResourceResponse(List<LibraryResource> resources, String message, String status, String error, String timestamp, Integer code, Boolean success) {
        this.resources = resources;
        this.message = message;
        this.status = status;
        this.error = error;
        this.timestamp = timestamp;
        this.code = code;
        this.success = success;
    }

    public List<LibraryResource> getResources() {
        return resources;
    }

    public void setResources(List<LibraryResource> resources) {
        this.resources = resources;
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

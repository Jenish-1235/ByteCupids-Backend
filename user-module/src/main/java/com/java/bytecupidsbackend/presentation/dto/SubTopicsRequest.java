package com.java.bytecupidsbackend.presentation.dto;

public class SubTopicsRequest {
    private String moduleId;
    private String accessToken;
    public SubTopicsRequest() {}
    public SubTopicsRequest(String moduleId, String accessToken) {
        this.moduleId = moduleId;
        this.accessToken = accessToken;
    }
    public String getModuleId() {
        return moduleId;
    }
    public void setModuleId(String moduleId) {
        this.moduleId = moduleId;
    }
    public String getAccessToken() {
        return accessToken;
    }
    public void setAccessToken(String accessToken) {
        this.accessToken = accessToken;
    }
}

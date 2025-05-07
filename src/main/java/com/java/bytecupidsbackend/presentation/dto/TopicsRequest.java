package com.java.bytecupidsbackend.presentation.dto;

public class TopicsRequest {
    private String moduleId;
    private String accessToken;
    public TopicsRequest() {}
    public TopicsRequest(String moduleId, String accessToken) {
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

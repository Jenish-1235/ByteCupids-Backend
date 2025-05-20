package com.java.bytecupidsbackend.presentation.dto;

public class ContentCurationRequest {

    private String accessToken;
    private String moduleId;

    public ContentCurationRequest() {}
    public ContentCurationRequest(String accessToken, String moduleId) {
        this.accessToken = accessToken;
        this.moduleId = moduleId;
    }
    public String getAccessToken() {
        return accessToken;
    }
    public void setAccessToken(String accessToken) {
        this.accessToken = accessToken;
    }
    public String getModuleId() {
        return moduleId;
    }
    public void setModuleId(String moduleId) {
        this.moduleId = moduleId;
    }
}

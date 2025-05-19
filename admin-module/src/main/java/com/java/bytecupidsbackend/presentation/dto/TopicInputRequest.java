package com.java.bytecupidsbackend.presentation.dto;

public class TopicInputRequest {
    private String accessToken;
    private String moduleInfo;

    public TopicInputRequest() {}
    public TopicInputRequest(String accessToken, String moduleInfo) {
        this.accessToken = accessToken;
        this.moduleInfo = moduleInfo;
    }
    public String getAccessToken() {
        return accessToken;
    }
    public void setAccessToken(String accessToken) {
        this.accessToken = accessToken;
    }
    public String getModuleInfo() {
        return moduleInfo;
    }
    public void setModuleInfo(String moduleInfo) {
        this.moduleInfo = moduleInfo;
    }
}

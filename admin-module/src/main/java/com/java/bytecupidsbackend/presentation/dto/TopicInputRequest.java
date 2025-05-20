package com.java.bytecupidsbackend.presentation.dto;

import java.util.Map;

public class TopicInputRequest {
    private String accessToken;
    private Map<String, Object> moduleInfo;

    public TopicInputRequest() {}

    public TopicInputRequest(String accessToken, Map<String, Object> moduleInfo) {
        this.accessToken = accessToken;
        this.moduleInfo = moduleInfo;
    }

    public String getAccessToken() {
        return accessToken;
    }

    public void setAccessToken(String accessToken) {
        this.accessToken = accessToken;
    }

    public Map<String, Object> getModuleInfo() {
        return moduleInfo;
    }

    public void setModuleInfo(Map<String, Object> moduleInfo) {
        this.moduleInfo = moduleInfo;
    }
}

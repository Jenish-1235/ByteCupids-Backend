package com.java.bytecupidsbackend.presentation.dto;

public class AdminCreateModuleRequest {
    private String accessToken;
    private String moduleName;
    private String moduleMetadata;

    public AdminCreateModuleRequest() {

    }
    public AdminCreateModuleRequest(String accessToken, String moduleName, String moduleMetadata) {
        this.accessToken = accessToken;
        this.moduleName = moduleName;
        this.moduleMetadata = moduleMetadata;
    }

    public String getAccessToken() {
        return accessToken;
    }
    public void setAccessToken(String accessToken) {
        this.accessToken = accessToken;
    }
    public String getModuleName() {
        return moduleName;
    }
    public void setModuleName(String moduleName) {
        this.moduleName = moduleName;
    }
    public String getModuleMetadata() {
        return moduleMetadata;
    }
    public void setModuleMetadata(String moduleMetadata) {
        this.moduleMetadata = moduleMetadata;
    }
}

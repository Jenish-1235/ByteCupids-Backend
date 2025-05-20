package com.java.bytecupidsbackend.presentation.dto;

public class ModuleInputResponse {
    private String moduleName;
    private String moduleId;
    private String message;
    private String status;
    private String error;
    private String timeStamp;
    private Integer code;
    private Boolean success;

    public ModuleInputResponse() {}

    public ModuleInputResponse(String moduleName, String moduleId, String message, String status, String error, String timeStamp, Integer code, Boolean success) {
        this.moduleName = moduleName;
        this.moduleId = moduleId;
        this.message = message;
        this.status = status;
        this.error = error;
        this.timeStamp = timeStamp;
        this.code = code;
        this.success = success;
    }

    public String getModuleName() {
        return moduleName;
    }

    public void setModuleName(String moduleName) {
        this.moduleName = moduleName;
    }

    public String getModuleId() {
        return moduleId;
    }

    public void setModuleId(String moduleId) {
        this.moduleId = moduleId;
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

    public String getTimeStamp() {
        return timeStamp;
    }

    public void setTimeStamp(String timeStamp) {
        this.timeStamp = timeStamp;
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

package com.java.bytecupidsbackend.presentation.dto;

import com.java.bytecupidsbackend.domain.model.Module;
public class ModuleDeleteResponse {

    private Module module;
    private String message;
    private Boolean success;
    private Integer code;
    private String timestamp;

    public ModuleDeleteResponse() {}

    public ModuleDeleteResponse(Module module, String message, Boolean success, Integer code, String timestamp) {
        this.module = module;
        this.message = message;
        this.success = success;
        this.code = code;
        this.timestamp = timestamp;
    }

    public Module getModule() {
        return module;
    }

    public void setModule(Module module) {
        this.module = module;
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

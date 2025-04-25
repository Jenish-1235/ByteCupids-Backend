package com.java.bytecupidsbackend.presentation.dto;

import java.util.HashMap;
import java.util.List;
import com.java.bytecupidsbackend.domain.model.Module;

public class LabModuleResponse {
    List<Module> modules;
    private String message;
    private String status;
    private String error;
    private Boolean success;
    private Integer code;
    private String timestamp;
    public void setModules(final List<Module> modules) {
        this.modules = modules;
    }
    public List<Module> getModules() {
        return modules;
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

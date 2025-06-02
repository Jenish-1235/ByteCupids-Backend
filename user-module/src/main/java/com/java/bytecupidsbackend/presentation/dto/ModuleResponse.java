package com.java.bytecupidsbackend.presentation.dto;

import java.util.List;
import com.java.bytecupidsbackend.domain.model.Module;

public class ModuleResponse {
    List<Module> modules;
    private String message;
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

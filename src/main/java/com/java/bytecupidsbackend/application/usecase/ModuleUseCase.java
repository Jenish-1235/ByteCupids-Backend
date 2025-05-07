package com.java.bytecupidsbackend.application.usecase;

import com.java.bytecupidsbackend.domain.model.Module;
import com.java.bytecupidsbackend.domain.repository.ModuleRepository;
import com.java.bytecupidsbackend.presentation.dto.ModuleResponse;

import java.util.List;

public class ModuleUseCase {

    private final ModuleRepository moduleRepository;

    public ModuleUseCase(final ModuleRepository moduleRepository) {
        this.moduleRepository = moduleRepository;
    }

    public ModuleResponse getModules(){
        ModuleResponse response = new ModuleResponse();
        response.setTimestamp(String.valueOf(System.currentTimeMillis()));
        List<Module> moduleList = moduleRepository.getAllModules();
        response.setModules(moduleList);
        if (!moduleList.isEmpty()) {
            response.setMessage("Found " + moduleList.size() + " modules");
            response.setSuccess(true);
            response.setCode(200);
            response.setStatus("Success");
        }
        else{
            response.setMessage("Modules not loaded");
            response.setSuccess(false);
            response.setCode(404);
            response.setStatus("Error");
            response.setError("No modules found");
        }
        return response;
    }
}

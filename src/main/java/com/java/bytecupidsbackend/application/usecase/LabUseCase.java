package com.java.bytecupidsbackend.application.usecase;

import com.java.bytecupidsbackend.domain.model.Module;
import com.java.bytecupidsbackend.domain.repository.ModuleRepository;
import com.java.bytecupidsbackend.presentation.dto.LabModuleResponse;

import java.util.List;

public class LabUseCase {

    private final ModuleRepository moduleRepository;

    public LabUseCase(final ModuleRepository moduleRepository) {
        this.moduleRepository = moduleRepository;
    }

    public LabModuleResponse getModules(){
        LabModuleResponse modules = new LabModuleResponse();
        modules.setTimestamp(String.valueOf(System.currentTimeMillis()));
        List<Module> moduleList = moduleRepository.getAllModules();

        if (moduleList.size() > 0) {
            modules.setModules(moduleList);
            modules.setMessage("Modules loaded");
            modules.setSuccess(true);
            modules.setCode(200);
            modules.setStatus("Success");
            return modules;
        }
        else{
            modules.setModules(moduleList);
            modules.setMessage("Modules not loaded");
            modules.setSuccess(false);
            modules.setCode(404);
            modules.setStatus("Error");
            modules.setError("No modules found");
            return modules;
        }
    }
}

package com.java.bytecupidsbackend.presentation.controller;

import com.java.bytecupidsbackend.application.usecase.ModuleUseCase;
import com.java.bytecupidsbackend.domain.model.Organisation;
import com.java.bytecupidsbackend.domain.repository.ModuleRepository;
import com.java.bytecupidsbackend.domain.repository.OrganisationRepository;
import com.java.bytecupidsbackend.infrastructure.persistence.adapter.JpaModuleRepository;
import com.java.bytecupidsbackend.presentation.dto.ModuleDeleteRequest;
import com.java.bytecupidsbackend.presentation.dto.ModuleDeleteResponse;
import com.java.bytecupidsbackend.presentation.dto.ModuleSaveRequest;
import com.java.bytecupidsbackend.presentation.dto.ModuleSaveResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.java.bytecupidsbackend.domain.model.Module;

import java.util.Optional;
import java.util.UUID;

@RestController
@RequestMapping("/bytecupids/lab")
public class ModulesController {

    private final ModuleUseCase labModuleUseCase;

    private final ModuleRepository moduleRepository;
    private final OrganisationRepository organisationRepository;
    private final JpaModuleRepository jpaModuleRepository;

    @Autowired
    public ModulesController(final ModuleUseCase labModuleUseCase, ModuleRepository moduleRepository, OrganisationRepository organisationRepository, JpaModuleRepository jpaModuleRepository) {
        this.labModuleUseCase = labModuleUseCase;
        this.moduleRepository = moduleRepository;
        this.organisationRepository = organisationRepository;
        this.jpaModuleRepository = jpaModuleRepository;
    }

    @PostMapping
            ("/get_modules")
    public ResponseEntity<?> getModules() {
        return ResponseEntity.ok().body(labModuleUseCase.getModules());
    }

    @PostMapping("/save_module")
    public ResponseEntity<?> saveModule(@RequestBody ModuleSaveRequest request) {

        try {

            Module newModule = new Module(UUID.fromString(request.getModuleId()), request.getModuleName(), request.getNoOfTopics(), request.getNoOfSubTopics(), request.getPrerequisites(), request.getTargetAudience(), request.getEstimatedTime(), request.getInterpretation(), request.getAgentNotes(), request.getDifficultyLevel(), request.getLastUpdateTime(), request.getOrganisationId(), request.getDeleted());

            moduleRepository.saveModule(newModule);

            ModuleSaveResponse response = new ModuleSaveResponse();
            response.setModule(newModule);
            response.setTimestamp(String.valueOf(System.currentTimeMillis()));
            response.setSuccess(true);
            response.setMessage("Module " + newModule.getModuleName() + " saved successfully");
            response.setCode(200);

            return ResponseEntity.ok().body(response);

        }catch (Exception e) {
            ModuleSaveResponse errorResponse = new ModuleSaveResponse();
            errorResponse.setSuccess(false);
            errorResponse.setMessage("Failed to save module: " + e.getMessage());
            errorResponse.setTimestamp(String.valueOf(System.currentTimeMillis()));
            errorResponse.setCode(500);

            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(errorResponse);
        }

    }

    @PostMapping("/delete_module")
    public ResponseEntity<?> deleteModule(@RequestBody ModuleDeleteRequest request) {
        try {

            Optional<Module> module = moduleRepository.getModuleByModuleId(UUID.fromString(request.getModuleId()));
            Module moduleToDelete = module.get();

            moduleToDelete.setDeleted(true);

            moduleRepository.saveModule(moduleToDelete);

            ModuleDeleteResponse response = new ModuleDeleteResponse();
            response.setModule(moduleToDelete);
            response.setTimestamp(String.valueOf(System.currentTimeMillis()));
            response.setSuccess(true);
            response.setMessage("Module " + moduleToDelete.getModuleName() + " deleted successfully");
            response.setCode(200);
            return ResponseEntity.ok().body(response);

        } catch (Exception e) {
            ModuleDeleteResponse errorResponse = new ModuleDeleteResponse();
            errorResponse.setSuccess(false);
            errorResponse.setMessage("Failed to delete module: " + e.getMessage());
            errorResponse.setTimestamp(String.valueOf(System.currentTimeMillis()));
            errorResponse.setCode(500);
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(errorResponse);
        }
    }


}

package com.java.bytecupidsbackend.presentation.controller;

import com.java.bytecupidsbackend.application.usecase.ModuleUseCase;
import com.java.bytecupidsbackend.domain.model.Organisation;
import com.java.bytecupidsbackend.domain.repository.ModuleRepository;
import com.java.bytecupidsbackend.domain.repository.OrganisationRepository;
import com.java.bytecupidsbackend.infrastructure.persistence.entity.OrganisationEntity;
import com.java.bytecupidsbackend.presentation.dto.ModuleSaveRequest;
import org.springframework.beans.factory.annotation.Autowired;
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

    @Autowired
    public ModulesController(final ModuleUseCase labModuleUseCase, ModuleRepository moduleRepository, OrganisationRepository organisationRepository) {
        this.labModuleUseCase = labModuleUseCase;
        this.moduleRepository = moduleRepository;
        this.organisationRepository = organisationRepository;
    }

    @PostMapping
            ("/get_modules")
    public ResponseEntity<?> getModules() {
        return ResponseEntity.ok().body(labModuleUseCase.getModules());
    }

    @PostMapping("/save_module")
    public ResponseEntity<?> saveModule(@RequestBody ModuleSaveRequest request) {
        Module newModule = new Module(UUID.fromString(request.getModuleId()),request.getModuleName(),request.getNoOfTopics(), request.getNoOfSubTopics(), request.getPrerequisites(),request.getTargetAudience(),request.getEstimatedTime(),request.getInterpretation(),request.getAgentNotes(),request.getDifficultyLevel(),request.getLastUpdateTime(),request.getOrganisation(), false);
        moduleRepository.saveModule(newModule);
        return ResponseEntity.ok().body(newModule);
    }


}

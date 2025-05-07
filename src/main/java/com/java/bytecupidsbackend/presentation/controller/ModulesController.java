package com.java.bytecupidsbackend.presentation.controller;

import com.java.bytecupidsbackend.application.usecase.ModuleUseCase;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/bytecupids/lab")
public class ModulesController {

    private final ModuleUseCase labModuleUseCase;

    public ModulesController(final ModuleUseCase labModuleUseCase) {
        this.labModuleUseCase = labModuleUseCase;
    }

    @PostMapping
            ("/get_modules")
    public ResponseEntity getModules() {
        return ResponseEntity.ok().body(labModuleUseCase.getModules());
    }
}

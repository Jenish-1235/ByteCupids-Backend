package com.java.bytecupidsbackend.presentation.controller;

import com.java.bytecupidsbackend.application.usecase.ModuleInputUseCase;
import com.java.bytecupidsbackend.presentation.dto.ModuleInputRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/bytecupids/admin")
public class ModuleInputController {

    private final ModuleInputUseCase moduleInputUseCase;

    public ModuleInputController(final ModuleInputUseCase moduleInputUseCase) {
        this.moduleInputUseCase = moduleInputUseCase;
    }

    @PostMapping
            ("/create_module")
    public ResponseEntity<?> createModule(@RequestBody ModuleInputRequest r) {
        // TODO: Perform JWT check on admin role
        return ResponseEntity.ok().body(moduleInputUseCase.execute(r.getModuleName(), r.getModuleMetadata()));
    }
}

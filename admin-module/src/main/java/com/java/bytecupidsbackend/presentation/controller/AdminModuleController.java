package com.java.bytecupidsbackend.presentation.controller;

import com.java.bytecupidsbackend.application.usecase.admin.AdminModuleUseCase;
import com.java.bytecupidsbackend.presentation.dto.admin.AdminCreateModuleRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/bytecupids/admin")
public class AdminModuleController {

    private final AdminModuleUseCase adminModuleUseCase;

    public AdminModuleController(final AdminModuleUseCase adminModuleUseCase) {
        this.adminModuleUseCase = adminModuleUseCase;
    }

    @PostMapping
            ("/create_module")
    public ResponseEntity<?> createModule(@RequestBody AdminCreateModuleRequest r) {
        // TODO: Perform JWT check on admin role
        return ResponseEntity.ok().body(adminModuleUseCase.execute(r.getModuleName(), r.getModuleMetadata()));
    }
}

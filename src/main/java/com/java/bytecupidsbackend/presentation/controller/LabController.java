package com.java.bytecupidsbackend.presentation.controller;

import com.java.bytecupidsbackend.application.usecase.LabUseCase;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/bytecupids/lab")
public class LabController {

    private final LabUseCase labUseCase;

    public LabController(final LabUseCase labUseCase) {
        this.labUseCase = labUseCase;
    }

    @GetMapping
            ("/get_modules")
    public ResponseEntity getModules() {
        return ResponseEntity.ok().body(labUseCase.getModules());
    }
}

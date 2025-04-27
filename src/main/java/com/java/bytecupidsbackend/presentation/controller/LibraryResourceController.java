package com.java.bytecupidsbackend.presentation.controller;


import com.java.bytecupidsbackend.application.usecase.LibraryResourcesUseCase;
import com.java.bytecupidsbackend.presentation.dto.LibraryResourceRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RestController
@RequestMapping("/bytecupids/lab")
public class LibraryResourceController {

    private final LibraryResourcesUseCase libraryResourcesUseCase;

    public LibraryResourceController(final LibraryResourcesUseCase libraryResourcesUseCase) {
        this.libraryResourcesUseCase = libraryResourcesUseCase;
    }

    @PostMapping("/get_resources")
    public ResponseEntity<?> getResources(@RequestBody LibraryResourceRequest request){
        return ResponseEntity.ok().body(libraryResourcesUseCase.getResourcesByModuleId(UUID.fromString(request.getModuleId())));
    }
}

package com.java.bytecupidsbackend.application.usecase;

import com.java.bytecupidsbackend.domain.model.LibraryResource;
import com.java.bytecupidsbackend.domain.repository.LibraryResourceRepository;
import com.java.bytecupidsbackend.presentation.dto.LibraryResourceResponse;

import java.util.List;
import java.util.UUID;

public class LibraryResourcesUseCase {

    private final LibraryResourceRepository libraryResourceRepository;
    public LibraryResourcesUseCase(final LibraryResourceRepository libraryResourceRepository) {
        this.libraryResourceRepository = libraryResourceRepository;
    }

    public LibraryResourceResponse getResourcesByModuleId(UUID moduleId){
        LibraryResourceResponse response = new LibraryResourceResponse();

        List<LibraryResource> resources = libraryResourceRepository.getResourcesByModuleId(moduleId);
        response.setTimestamp(String.valueOf(System.currentTimeMillis()));
        response.setResources(resources);
        if (!resources.isEmpty()) {
            response.setMessage("Found " + resources.size() + " resources");
            response.setSuccess(true);
            response.setCode(200);
            response.setStatus("SUCCESS");
        }else {
            response.setMessage("No resources found");
            response.setSuccess(false);
            response.setCode(404);
            response.setStatus("ERROR");
        }



        return response;
    }
}

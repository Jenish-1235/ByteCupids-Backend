package com.java.bytecupidsbackend.infrastructure.persistence.adapter;

import com.java.bytecupidsbackend.domain.model.LibraryResource;
import com.java.bytecupidsbackend.domain.repository.LibraryResourceRepository;
import com.java.bytecupidsbackend.infrastructure.persistence.entity.LibraryResourceEntity;
import kotlin.contracts.Returns;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Component
public class LibraryResourceAdapter implements LibraryResourceRepository {
    private final JpaLibraryResourceRepository jpaRepository;
    public LibraryResourceAdapter(final JpaLibraryResourceRepository jpaRepository) {
        this.jpaRepository = jpaRepository;
    }

    @Override
    public List<LibraryResource> getResourcesByModuleId(UUID moduleId) {
        List<LibraryResourceEntity> entities = jpaRepository.findAllByModuleId(moduleId);
        List<LibraryResource> resources = new ArrayList<>();
        for (LibraryResourceEntity entity : entities) {
            resources.add(new LibraryResource(entity.getResourceId(), entity.getModuleId(), entity.getResourceName(), entity.getResourceType(), entity.getResourceUri()));
        }
        return resources;
    }
}

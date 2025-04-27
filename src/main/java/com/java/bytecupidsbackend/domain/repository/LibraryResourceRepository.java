package com.java.bytecupidsbackend.domain.repository;

import com.java.bytecupidsbackend.domain.model.LibraryResource;

import java.util.List;
import java.util.UUID;

public interface LibraryResourceRepository {
    List<LibraryResource> getResourcesByModuleId(UUID moduleId);
}

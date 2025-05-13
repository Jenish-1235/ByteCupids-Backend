package com.java.bytecupidsbackend.infrastructure.persistence.adapter;

import com.java.bytecupidsbackend.infrastructure.persistence.entity.LibraryResourceEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface JpaLibraryResourceRepository extends JpaRepository<LibraryResourceEntity, Long> {
    List<LibraryResourceEntity> findAllByModuleId(UUID moduleId);
}

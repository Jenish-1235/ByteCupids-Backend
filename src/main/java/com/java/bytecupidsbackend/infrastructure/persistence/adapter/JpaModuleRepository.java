package com.java.bytecupidsbackend.infrastructure.persistence.adapter;

import com.java.bytecupidsbackend.infrastructure.persistence.entity.ModuleEntity;
import org.jetbrains.annotations.NotNull;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface JpaModuleRepository extends JpaRepository<ModuleEntity, Long> {
    @NotNull
    @Override
    List<ModuleEntity> findAll();
}

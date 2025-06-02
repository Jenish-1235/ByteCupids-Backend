package com.java.bytecupidsbackend.infrastructure.persistence.adapter;

import com.java.bytecupidsbackend.infrastructure.persistence.entity.ModuleEntity;
import org.antlr.v4.runtime.misc.NotNull;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.UUID;


public interface JpaModuleRepository extends JpaRepository<ModuleEntity, UUID> {
    @NotNull
    @Override
    List<ModuleEntity> findAll();

    @Override
    ModuleEntity save(ModuleEntity module);
}

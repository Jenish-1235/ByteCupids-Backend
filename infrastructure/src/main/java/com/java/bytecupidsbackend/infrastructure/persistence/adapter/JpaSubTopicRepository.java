package com.java.bytecupidsbackend.infrastructure.persistence.adapter;

import com.java.bytecupidsbackend.infrastructure.persistence.entity.SubTopicEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.UUID;


public interface JpaSubTopicRepository extends JpaRepository<SubTopicEntity, Long> {
    List<SubTopicEntity> findAllByModuleEntity_ModuleId(UUID moduleEntityModuleId);
}

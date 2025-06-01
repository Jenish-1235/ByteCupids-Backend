package com.java.bytecupidsbackend.infrastructure.persistence.adapter;

import com.java.bytecupidsbackend.domain.model.SubTopic;
import com.java.bytecupidsbackend.infrastructure.persistence.entity.SubTopicEntity;
import org.springframework.data.domain.Limit;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;


public interface JpaTopicRepository extends JpaRepository<SubTopicEntity, Long> {
    List<SubTopicEntity> findAllByModuleEntity_ModuleId(UUID moduleEntityModuleId);
}

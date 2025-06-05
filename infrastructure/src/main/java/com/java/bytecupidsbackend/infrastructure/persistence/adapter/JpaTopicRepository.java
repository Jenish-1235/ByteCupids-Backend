package com.java.bytecupidsbackend.infrastructure.persistence.adapter;

import com.java.bytecupidsbackend.infrastructure.persistence.entity.SubTopicEntity;
import com.java.bytecupidsbackend.infrastructure.persistence.entity.TopicEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface JpaTopicRepository extends JpaRepository<TopicEntity, UUID> {
 List<TopicEntity> findAllByModuleEntity_ModuleId(UUID moduleEntityModuleId);


 Optional<TopicEntity> findByTopicId(UUID topicId);

 TopicEntity save(TopicEntity topic);
}



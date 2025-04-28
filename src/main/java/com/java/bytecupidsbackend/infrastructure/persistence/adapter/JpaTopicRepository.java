package com.java.bytecupidsbackend.infrastructure.persistence.adapter;

import com.java.bytecupidsbackend.domain.model.Topic;
import com.java.bytecupidsbackend.infrastructure.persistence.entity.TopicEntity;
import jakarta.validation.constraints.NotNull;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface JpaTopicRepository extends JpaRepository<TopicEntity, Long> {
    List<TopicEntity> findAllByModuleId(UUID moduleId);
}

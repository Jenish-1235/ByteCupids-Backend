package com.java.bytecupidsbackend.infrastructure.persistence.adapter;

import com.java.bytecupidsbackend.domain.model.SubTopic;
import com.java.bytecupidsbackend.domain.repository.SubTopicRepository;
import com.java.bytecupidsbackend.infrastructure.persistence.entity.SubTopicEntity;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Component
public class SubTopicRepositoryAdapter implements SubTopicRepository {
    private final JpaSubTopicRepository jpaSubTopicRepository;

    public SubTopicRepositoryAdapter(final JpaSubTopicRepository jpaSubTopicRepository) {
        this.jpaSubTopicRepository = jpaSubTopicRepository;
    }

    @Override
    public List<SubTopic> getAllSubTopics(String moduleId) {
        List<SubTopicEntity> subtopicEntityList = jpaSubTopicRepository.findAllByModuleEntity_ModuleId(UUID.fromString(moduleId));
        List<SubTopic> subtopics = new ArrayList<>();
        for (SubTopicEntity subTopicEntity : subtopicEntityList) {
            subtopics.add(new SubTopic(
                    subTopicEntity.getSubTopicId(),
                    subTopicEntity.getModuleEntity().getModuleId(),
                    subTopicEntity.getTopicEntity().getTopicId(),
                    subTopicEntity.getSubTopicName(),
                    subTopicEntity.getSequenceNumber()
            ));
        }
        return subtopics;
    }
}
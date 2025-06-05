package com.java.bytecupidsbackend.infrastructure.persistence.adapter;

import com.java.bytecupidsbackend.domain.model.SubTopic;
import com.java.bytecupidsbackend.domain.model.Topic;
import com.java.bytecupidsbackend.domain.repository.SubTopicRepository;
import com.java.bytecupidsbackend.infrastructure.persistence.entity.ModuleEntity;
import com.java.bytecupidsbackend.infrastructure.persistence.entity.SubTopicEntity;
import com.java.bytecupidsbackend.infrastructure.persistence.entity.TopicEntity;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Component
public class SubTopicRepositoryAdapter implements SubTopicRepository {
    private final JpaSubTopicRepository jpaSubTopicRepository;
    private final JpaTopicRepository jpaTopicRepository;
    private final JpaModuleRepository jpaModuleRepository;

    public SubTopicRepositoryAdapter(final JpaSubTopicRepository jpaSubTopicRepository, JpaTopicRepository jpaTopicRepository, JpaModuleRepository jpaModuleRepository) {
        this.jpaSubTopicRepository = jpaSubTopicRepository;
        this.jpaTopicRepository = jpaTopicRepository;
        this.jpaModuleRepository = jpaModuleRepository;
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
                    subTopicEntity.getSequenceNumber(),
                    subTopicEntity.getDeleted()
            ));
        }
        return subtopics;
    }

    public Optional<SubTopic> findBySubTopicId(UUID subtopicId) {
        Optional<SubTopicEntity> subtopicEntityOptional = jpaSubTopicRepository.findBySubTopicId(subtopicId);

        if (subtopicEntityOptional.isPresent()) {
            SubTopicEntity subtopicEntity = subtopicEntityOptional.get();
            SubTopic subTopic = new SubTopic(
                    subtopicEntity.getSubTopicId(),
                    subtopicEntity.getModuleEntity().getModuleId(),
                    subtopicEntity.getTopicEntity().getTopicId(),
                    subtopicEntity.getSubTopicName(),
                    subtopicEntity.getSequenceNumber(),
                    subtopicEntity.getDeleted()
            );
        return Optional.of(subTopic);
        }else{
            return Optional.empty();
        }
    }

    @Override
    public void saveSubTopic(SubTopic subtopic) {
        Optional<TopicEntity> topicEntity = jpaTopicRepository.findByTopicId(subtopic.getTopicId());
        Optional<ModuleEntity> moduleEntity = jpaModuleRepository.findByModuleId(subtopic.getModuleId());

        if (topicEntity.isPresent() && moduleEntity.isPresent()) {
            TopicEntity topic = topicEntity.get();
            ModuleEntity module = moduleEntity.get();
            jpaSubTopicRepository.save(new SubTopicEntity(
                    subtopic.getSubTopicId(),
                    module,
                    topic,
                    subtopic.getSubTopicName(),
                    subtopic.getSequenceNumber(),
                    subtopic.getDeleted()
            ));
        }

    }
}
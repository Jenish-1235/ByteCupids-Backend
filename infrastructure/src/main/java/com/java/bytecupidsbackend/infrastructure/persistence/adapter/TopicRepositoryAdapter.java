package com.java.bytecupidsbackend.infrastructure.persistence.adapter;

import com.java.bytecupidsbackend.domain.model.Topic;
import com.java.bytecupidsbackend.domain.repository.TopicRepository;
import com.java.bytecupidsbackend.infrastructure.persistence.entity.TopicEntity;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Component
public class TopicRepositoryAdapter implements TopicRepository {
    private final JpaTopicRepository jpaTopicRepository;

    public TopicRepositoryAdapter(final JpaTopicRepository jpaTopicRepository) {
        this.jpaTopicRepository = jpaTopicRepository;
    }

    @Override
    public List<Topic> getAllTopics(String moduleId) {
        List<TopicEntity> topicEntityList = jpaTopicRepository.findAllByModuleEntity_ModuleId(UUID.fromString(moduleId));
        List<Topic> topics = new ArrayList<>();
        for (TopicEntity topicEntity : topicEntityList) {
            topics.add(new Topic(
                    topicEntity.getTopicId(),
                    topicEntity.getTopicName(),
                    topicEntity.getModuleEntity().getModuleId()
            ));
        }
        return topics;
    }
}

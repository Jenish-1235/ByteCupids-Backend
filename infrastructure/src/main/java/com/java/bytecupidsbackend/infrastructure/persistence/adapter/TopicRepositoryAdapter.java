package com.java.bytecupidsbackend.infrastructure.persistence.adapter;

import com.java.bytecupidsbackend.domain.model.SubTopic;
import com.java.bytecupidsbackend.domain.repository.TopicRepository;
import com.java.bytecupidsbackend.infrastructure.persistence.entity.SubTopicEntity;
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
    public List<SubTopic> getAllTopics(String moduleId){
        List<SubTopicEntity> topicEntityList = jpaTopicRepository.findAllByModuleId(UUID.fromString(moduleId));
        List<SubTopic> topics = new ArrayList<>();
        for (SubTopicEntity topicEntity : topicEntityList) {
            topics.add(new SubTopic(topicEntity.getSubTopicId(), topicEntity.getModuleId(), topicEntity.getTopicName(), topicEntity.getSubTopicName()));
        }
        return topics;
    }
}

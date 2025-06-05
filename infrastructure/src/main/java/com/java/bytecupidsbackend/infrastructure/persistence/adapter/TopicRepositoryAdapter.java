package com.java.bytecupidsbackend.infrastructure.persistence.adapter;

import com.java.bytecupidsbackend.domain.model.Topic;
import com.java.bytecupidsbackend.domain.repository.TopicRepository;
import com.java.bytecupidsbackend.infrastructure.persistence.entity.ModuleEntity;
import com.java.bytecupidsbackend.infrastructure.persistence.entity.TopicEntity;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Component
public class TopicRepositoryAdapter implements TopicRepository {
    private final JpaTopicRepository jpaTopicRepository;
    private final JpaModuleRepository jpaModuleRepository;

    public TopicRepositoryAdapter(final JpaTopicRepository jpaTopicRepository, JpaModuleRepository jpaModuleRepository) {
        this.jpaTopicRepository = jpaTopicRepository;
        this.jpaModuleRepository = jpaModuleRepository;
    }

    @Override
    public List<Topic> getAllTopics(String moduleId) {
        List<TopicEntity> topicEntityList = jpaTopicRepository.findAllByModuleEntity_ModuleId(UUID.fromString(moduleId));
        List<Topic> topics = new ArrayList<>();
        for (TopicEntity topicEntity : topicEntityList) {
            topics.add(new Topic(
                    topicEntity.getTopicId(),
                    topicEntity.getTopicName(),
                    topicEntity.getModuleEntity().getModuleId(),
                    topicEntity.getDeleted()
            ));
        }
        return topics;
    }

    public Optional<Topic> findByTopicId(UUID topicId) {
        Optional<TopicEntity> topicEntityOptional = jpaTopicRepository.findByTopicId(topicId);

        if(topicEntityOptional.isPresent()) {
            TopicEntity topicEntity = topicEntityOptional.get();

            Topic topic = new Topic(
                    topicEntity.getTopicId(),
                    topicEntity.getTopicName(),
                    topicEntity.getModuleEntity().getModuleId(),
                    topicEntity.getDeleted()
            );
        return Optional.of(topic);
        }
        else {
            return Optional.empty();
        }
    }

    public void saveTopic(Topic topic) {
        Optional<ModuleEntity> moduleEntity = jpaModuleRepository.findByModuleId(topic.getModuleId());
        if (moduleEntity.isPresent()) {
            ModuleEntity module = moduleEntity.get();
            jpaTopicRepository.save(new TopicEntity(topic.getTopicId(), module, topic.getTopicName(), topic.getDeleted()));
        }

    }
}

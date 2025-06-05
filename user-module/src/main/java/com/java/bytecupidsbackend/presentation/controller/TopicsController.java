package com.java.bytecupidsbackend.presentation.controller;

import com.java.bytecupidsbackend.application.usecase.TopicUseCase;
import com.java.bytecupidsbackend.domain.model.Topic;
import com.java.bytecupidsbackend.domain.repository.TopicRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.java.bytecupidsbackend.presentation.dto.TopicDeleteRequest;
import com.java.bytecupidsbackend.presentation.dto.TopicDeleteResponse;
import java.util.Optional;
import java.util.UUID;


@RestController
@RequestMapping("/bytecupids/lab")
public class TopicsController {

    private final TopicUseCase labtopicUseCase;
    private final TopicRepository topicRepository;


    public TopicsController(final TopicUseCase labtopicUseCase, TopicRepository topicRepository) {
        this.labtopicUseCase = labtopicUseCase;
        this.topicRepository = topicRepository;
    }

    @PostMapping("/get_topics")
    public ResponseEntity<?> getLabTopics(@RequestBody TopicDeleteRequest request) {
        return ResponseEntity.ok().body(labtopicUseCase.getAllTopics(request.getTopicId()));
    }

    @PostMapping("/delete_topic")
    public ResponseEntity<?> deleteLabTopics(@RequestBody TopicDeleteRequest request) {
        try{

            Optional<Topic> topic = topicRepository.findByTopicId(UUID.fromString(request.getTopicId().trim()));

            Topic topicToDelete = topic.get();


            topicToDelete.setDeleted(true);

            topicRepository.saveTopic(topicToDelete);

            TopicDeleteResponse response = new TopicDeleteResponse();
            response.setCode(200);
            response.setMessage("Deleted topic: " + topicToDelete.getTopicName());
            response.setSuccess(true);
            response.setTimestamp(String.valueOf(System.currentTimeMillis()));

            return ResponseEntity.ok().body(response);
        }catch (Exception e){
            TopicDeleteResponse response = new TopicDeleteResponse();
            response.setCode(500);
            response.setSuccess(false);
            response.setTimestamp(String.valueOf(System.currentTimeMillis()));
            response.setMessage("Failed to delete topic: "+e.getMessage());

            return ResponseEntity.status(500).body(response);
        }
    }
}

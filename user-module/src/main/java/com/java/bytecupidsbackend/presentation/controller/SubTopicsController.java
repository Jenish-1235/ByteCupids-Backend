package com.java.bytecupidsbackend.presentation.controller;

import com.java.bytecupidsbackend.application.usecase.SubTopicUseCase;
import com.java.bytecupidsbackend.domain.model.SubTopic;
import com.java.bytecupidsbackend.domain.repository.SubTopicRepository;
import com.java.bytecupidsbackend.presentation.dto.SubTopicDeleteRequest;
import com.java.bytecupidsbackend.presentation.dto.SubTopicDeleteResponse;
import com.java.bytecupidsbackend.presentation.dto.SubTopicsRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;
import java.util.UUID;

@RestController
@RequestMapping("/bytecupids/lab")
public class SubTopicsController {

    private final SubTopicUseCase labSubTopicUseCase;
    private final SubTopicRepository subTopicRepository;

    public SubTopicsController(final SubTopicUseCase labSubTopicUseCase, SubTopicRepository subTopicRepository) {
        this.labSubTopicUseCase = labSubTopicUseCase;
        this.subTopicRepository = subTopicRepository;
    }

    @PostMapping("/get_subtopics")
    public ResponseEntity<?> getLabSubTopics(@RequestBody SubTopicsRequest request) {
        return ResponseEntity.ok().body(labSubTopicUseCase.getAllSubTopics(request.getModuleId()));
    }

    @PostMapping("/delete_subtopic")
    public ResponseEntity<?> deleteLabSubTopic(@RequestBody SubTopicDeleteRequest request) {
        try{
            Optional<SubTopic> subTopic= subTopicRepository.findBySubTopicId(UUID.fromString(request.getSubtopicId()));

            SubTopic subTopicToDelete = subTopic.get();
            subTopicToDelete.setDeleted(true);

            subTopicRepository.saveSubTopic(subTopicToDelete);
            SubTopicDeleteResponse response = new SubTopicDeleteResponse();
            response.setCode(200);
            response.setMessage("Successfully deleted subtopic: "+subTopicToDelete.getSubTopicName());
            response.setSuccess(true);
            response.setTimestamp(String.valueOf(System.currentTimeMillis()));

            return ResponseEntity.ok().body(response);
        }catch (Exception e){
            SubTopicDeleteResponse response = new SubTopicDeleteResponse();
            response.setCode(500);
            response.setSuccess(false);
            response.setTimestamp(String.valueOf(System.currentTimeMillis()));
            response.setMessage("Failed to delete subtopic: "+ e.getMessage());
            return ResponseEntity.status(500).body(response);
        }
    }
}

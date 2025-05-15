package com.java.bytecupidsbackend.presentation.controller.streamcontrollers;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;

@RestController
        ("/bytecupids/admin/generate")
public class TopicInputStreamController {

    @PostMapping(value = "/topic-generator" , produces = MediaType.TEXT_EVENT_STREAM_VALUE)
    public Flux<String> streamTopicGenerator() {
        return Flux.empty();
    }
}

package com.java.bytecupidsbackend.services;

import reactor.core.publisher.Flux;

public interface ExternalLLmService {
    Flux<String> getStreamResponse(String agentKey, String systemPrompt, String userPrompt, double temperature);
    String getResponse(String agentKey, String systemPrompt, String userPrompt, double temperature);
}

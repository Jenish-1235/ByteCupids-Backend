package com.java.bytecupidsbackend.agentorchestration;

import reactor.core.publisher.Flux;

public interface AgentService {
    Flux<String> getResponse(String prompt, String agentKey);
}

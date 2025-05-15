package com.java.bytecupidsbackend.agentorchestration;

import org.springframework.stereotype.Component;
import reactor.core.publisher.Flux;

@Component
public class Manager {

    private final AgentFactory agentFactory;

    public Manager(AgentFactory agentFactory) {
        this.agentFactory = agentFactory;
    }

    public Flux<String> getStream(String prompt, String agentKey) {

        if (prompt.isEmpty() || agentKey.isEmpty()) {
            System.out.println("Empty prompt or agent key");
            return Flux.empty();
        }
        AgentService selectedAgent = agentFactory.getAgent(agentKey);
        return selectedAgent.getResponse(prompt, agentKey);
    }
}

package com.java.bytecupidsbackend.agentorchestration;

import org.springframework.stereotype.Component;

@Component
public class Manager {

    private final AgentFactory agentFactory;

    public Manager(AgentFactory agentFactory) {
        this.agentFactory = agentFactory;
    }

    public String execute(String prompt, String agentKey) {

        if (prompt.isEmpty() || agentKey.isEmpty()) {
            return "Please enter a prompt and a model";
        }
        AgentService selectedAgent = agentFactory.getAgent(agentKey);
        return selectedAgent.getResponse(prompt, agentKey);
    }
}

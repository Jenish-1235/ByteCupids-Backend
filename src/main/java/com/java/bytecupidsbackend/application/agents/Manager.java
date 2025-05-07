package com.java.bytecupidsbackend.application.agents;

import org.springframework.stereotype.Component;

@Component
public class Manager {
    public String execute(String prompt, String model) {
        if (prompt.equals("")) {
            return "Please enter a prompt for the model: " + model;
        }
        if (model.equals("")) {
            return "Please enter a model for the prompt: " + prompt;
        }
        AgentService agent = AgentFactory.getAgent(model);
        return agent.getResponse(prompt);
    }
}

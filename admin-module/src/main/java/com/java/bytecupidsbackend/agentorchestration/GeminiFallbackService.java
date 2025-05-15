package com.java.bytecupidsbackend.agentorchestration;

public class GeminiFallbackService implements AgentService{

    @Override
    public String getResponse(String prompt, String agentKey) {
        return prompt;
    }
}

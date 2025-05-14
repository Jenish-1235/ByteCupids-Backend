package com.java.bytecupidsbackend.agentorchestration;

public class ModuleInputFormatter implements AgentService {

    @Override
    public String getResponse(String prompt) {
        return prompt;
    }

}

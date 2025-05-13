package com.java.bytecupidsbackend.agentorchestration;

public class ClaudeAiService implements AgentService {

    @Override
    public String getResponse(String prompt){
        return "Response from ClaudeAi";
    }
}

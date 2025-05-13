package com.java.bytecupidsbackend.agentorchestration;

public class AgentFactory {

    public static AgentService getAgent(String model){
        switch (model) {
            case "CLAUDE":
                return new ClaudeAiService();
            case "OPENAI":
                return new OpenAIService();
            case "GEMINI":
                return new GeminiService();
            default:
                return new GeminiService();
        }
    }
}

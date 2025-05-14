package com.java.bytecupidsbackend.agentorchestration;

public class AgentFactory {

    public static AgentService getAgent(String model){
        switch (model) {
            case "ADMIN_INPUT_FORMATTER":
                return new ModuleInputFormatter();
            default:
                return new GeminiFallbackService();
        }
    }
}

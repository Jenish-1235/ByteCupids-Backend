package com.java.bytecupidsbackend.promptdirectory;

public class ModuleInputFormatterPromptProvider {
    public static String getPrompt(String moduleName, String moduleMetadata) {
        return "Prompt to structure the input from admin will go here." +
                moduleName + moduleMetadata;
    }
}

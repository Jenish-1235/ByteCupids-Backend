package com.java.bytecupidsbackend.presentation.dto;

public class SubTopicDeleteRequest {
    private String subtopicId;
    private String accessToken;

    public SubTopicDeleteRequest(String subtopicId, String accessToken) {}

    public SubTopicDeleteRequest() {}

    public void setSubtopicId(String subtopicId) {
        this.subtopicId = subtopicId;
    }

    public String getSubtopicId() {
        return subtopicId;
    }

    public String getAccessToken() {
        return accessToken;
    }

    public void setAccessToken(String accessToken) {
        this.accessToken = accessToken;
    }
}

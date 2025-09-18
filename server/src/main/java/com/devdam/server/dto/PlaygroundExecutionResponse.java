package com.devdam.server.dto;

import lombok.Data;

@Data
public class PlaygroundExecutionResponse {
    private boolean success;
    private String result;
    private String explanation;
    private String error;
    private String steps;
    
    public PlaygroundExecutionResponse() {}
    
    public PlaygroundExecutionResponse(boolean success) {
        this.success = success;
    }
    
    public static PlaygroundExecutionResponse success(String result, String explanation, String steps) {
        PlaygroundExecutionResponse response = new PlaygroundExecutionResponse(true);
        response.setResult(result);
        response.setExplanation(explanation);
        response.setSteps(steps);
        return response;
    }
    
    public static PlaygroundExecutionResponse error(String error) {
        PlaygroundExecutionResponse response = new PlaygroundExecutionResponse(false);
        response.setError(error);
        return response;
    }
}
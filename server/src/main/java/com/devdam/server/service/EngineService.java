package com.devdam.server.service;

import java.io.IOException;

import com.devdam.server.error.LazerSyntaxErrorException;

public interface EngineService {
    String[] executeCode(String code) throws LazerSyntaxErrorException;
    String promptAI(String code, String executionResults) throws IOException, InterruptedException;
}

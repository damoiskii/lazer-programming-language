package com.devdam.server.config;

import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;

import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;

import com.devdam.server.config.properties.NovitaProperties;

import jakarta.annotation.PostConstruct;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Configuration
@Slf4j
@EnableConfigurationProperties(NovitaProperties.class)
@RequiredArgsConstructor
public class AppConfig {
    private final NovitaProperties novitaProperties;
    private final ResourceLoader resourceLoader;

    @Getter
    private String guardRailContext;

    public String getNovitaApiKey() {
        return novitaProperties.getApiKey();
    }

    public String getNovitaUrl() {
        return novitaProperties.getUrl();
    }

    public String getNovitaModel() {
        return novitaProperties.getModel();
    }

    public int getNovitaMaxTokens() {
        return novitaProperties.getMaxTokens();
    }

    @PostConstruct
    private void loadContext() {
        try {
            loadAIAssistantChatbotGuardRailContextSystemPrompt();
        } catch (Exception e) {
            log.error("Error loading AI Assistant Chatbot configuration", e);
        }
    }

    private void loadAIAssistantChatbotGuardRailContextSystemPrompt() {
        Resource resource = resourceLoader.getResource("classpath:ai-contexts/safeguard.md");

        try (InputStream inputStream = resource.getInputStream()) {
            guardRailContext = new String(inputStream.readAllBytes(), StandardCharsets.UTF_8);
        }
        catch (IOException e) {
            throw new RuntimeException("Failed to load guardrail context", e);
        }
    }
}

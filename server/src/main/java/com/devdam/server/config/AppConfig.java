package com.devdam.server.config;

import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;

import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;

import com.devdam.server.config.properties.ClientProperties;
import com.devdam.server.config.properties.NovitaProperties;

import jakarta.annotation.PostConstruct;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Configuration
@Slf4j
@EnableConfigurationProperties({NovitaProperties.class, ClientProperties.class})
@RequiredArgsConstructor
public class AppConfig {
    private final NovitaProperties novitaProperties;
    private final ClientProperties clientProperties;
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

    public String getClientUrl() {
        return clientProperties.getUrl();
    }

    @PostConstruct
    private void loadContext() {
        try {
            loadAIAssistantChatbotGuardRailContextSystemPrompt();
        } catch (Exception e) {
            log.error("Error loading AI Assistant Chatbot configuration: {}", e.getMessage());
            // Don't throw the exception to prevent application startup failure
            guardRailContext = "Default safeguard context - configuration load failed";
        }
    }

    private void loadAIAssistantChatbotGuardRailContextSystemPrompt() {
        try {
            Resource resource = resourceLoader.getResource("classpath:static/ai-contexts/safeguard.md");
            
            if (!resource.exists()) {
                log.warn("Safeguard file not found at classpath:static/ai-contexts/safeguard.md");
                guardRailContext = "Default safeguard context - file not found";
                return;
            }
            
            try (InputStream inputStream = resource.getInputStream()) {
                guardRailContext = new String(inputStream.readAllBytes(), StandardCharsets.UTF_8);
                log.info("Successfully loaded safeguard context from safeguard.md");
            }
        }
        catch (IOException e) {
            log.error("Failed to load guardrail context from safeguard.md: {}", e.getMessage());
            guardRailContext = "Default safeguard context - failed to load file";
        }
    }
}

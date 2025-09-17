package com.devdam.server.config.properties;

import org.springframework.boot.context.properties.ConfigurationProperties;

import lombok.Data;

@ConfigurationProperties(prefix = "novita.ai")
@Data
public class NovitaProperties {
    private String url;
    private String model;
    private int maxTokens;
    private String apiKey;
}

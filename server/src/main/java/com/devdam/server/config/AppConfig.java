package com.devdam.server.config;

import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Configuration;

import com.devdam.server.config.properties.NovitaProperties;

import lombok.RequiredArgsConstructor;

@Configuration
@EnableConfigurationProperties(NovitaProperties.class)
@RequiredArgsConstructor
public class AppConfig {
    private final NovitaProperties novitaProperties;

    public String getNovitaApiKey() {
        return novitaProperties.getApiKey();
    }

    public String getNovitaUrl() {
        return novitaProperties.getUrl();
    }

    public String getNovitaModel() {
        return novitaProperties.getModel();
    }

    public int getNovitaMaxToken() {
        return novitaProperties.getMaxToken();
    }
}

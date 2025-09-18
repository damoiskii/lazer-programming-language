package com.devdam.server.config.properties;

import org.springframework.boot.context.properties.ConfigurationProperties;

import lombok.Data;

@Data
@ConfigurationProperties(prefix = "client")
public class ClientProperties {
    private String url;
}

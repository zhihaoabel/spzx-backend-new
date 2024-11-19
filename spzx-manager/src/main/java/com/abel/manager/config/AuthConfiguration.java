package com.abel.manager.config;

import java.util.List;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

import lombok.Data;

@Data
@Configuration
@ConfigurationProperties(prefix = "custom.auth")
public class AuthConfiguration {

    private List<String> excludeUrls;
}

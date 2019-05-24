package com.tongu.rbac.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

import lombok.Data;

@Data
@Configuration
@ConfigurationProperties("swagger")
public class SwaggerProperties {

	private String host;
}

package com.patterns.architecture.apigateway;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
public class ConfigurationClass {

	@Bean
	RestTemplate newRestTemplate() {
		return new RestTemplate();
	}
}

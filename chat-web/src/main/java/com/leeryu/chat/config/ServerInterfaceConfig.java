package com.leeryu.chat.config;

import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.client.BufferingClientHttpRequestFactory;
import org.springframework.http.client.SimpleClientHttpRequestFactory;
import org.springframework.http.converter.StringHttpMessageConverter;
import org.springframework.web.client.RestTemplate;

import java.nio.charset.StandardCharsets;
import java.time.Duration;

@Configuration
public class ServerInterfaceConfig {
	@Bean
	public RestTemplate restTemplate(RestTemplateBuilder builder) {
		return builder
				.requestFactory(() -> new BufferingClientHttpRequestFactory(new SimpleClientHttpRequestFactory()))
				.setConnectTimeout(Duration.ofMillis(5000))
				.setReadTimeout(Duration.ofMillis(5000))
				.additionalMessageConverters(new StringHttpMessageConverter(StandardCharsets.UTF_8))
				.build();
	}
}

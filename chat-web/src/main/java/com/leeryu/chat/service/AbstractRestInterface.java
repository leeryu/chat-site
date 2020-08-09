package com.leeryu.chat.service;

import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

public abstract class AbstractRestInterface {
	protected final RestTemplate restTemplate;

	public AbstractRestInterface(RestTemplate restTemplate) {
		this.restTemplate = restTemplate;
	}

	public <RESPONSE> ResponseEntity<RESPONSE> get(String url, HttpHeaders headers, Class<RESPONSE> responseType) {
		return call(url, HttpMethod.GET, headers, null, responseType);
	}

	public <RESPONSE> ResponseEntity<RESPONSE> get(String url, HttpHeaders headers, ParameterizedTypeReference<RESPONSE> responseType) {
		return call(url, HttpMethod.GET, headers, null, responseType);
	}

	public <RESPONSE> ResponseEntity<RESPONSE> call(String url, HttpMethod httpMethod, HttpHeaders headers, Object body, ParameterizedTypeReference<RESPONSE> responseType) {
		return restTemplate.exchange(url, httpMethod, new HttpEntity<>(body, headers), responseType);
	}

	public <RESPONSE> ResponseEntity<RESPONSE> call(String url, HttpMethod httpMethod, HttpHeaders headers, Object body, Class<RESPONSE> responseType) {
		return restTemplate.exchange(url, httpMethod, new HttpEntity<>(body, headers), responseType);
	}
}

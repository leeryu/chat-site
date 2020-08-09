package com.leeryu.chat.service;

import com.leeryu.chat.dto.PostsResponseDto;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Service
public class PostsRestInterface extends AbstractRestInterface {
	public PostsRestInterface(RestTemplate restTemplate) {
		super(restTemplate);
	}

	public ResponseEntity<List<PostsResponseDto>> findByAll() {
		return get("http://localhost:10080/api/v1/posts", null, new ParameterizedTypeReference<List<PostsResponseDto>>() {});
	}
}

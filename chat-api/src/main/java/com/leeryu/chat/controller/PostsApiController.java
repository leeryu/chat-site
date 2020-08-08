package com.leeryu.chat.controller;

import com.leeryu.chat.dto.PostsSaveRequestDto;
import com.leeryu.chat.service.posts.PostsService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController
public class PostsApiController {
	private final PostsService service;

	@PostMapping("/api/v1/posts")
	public Long save(@RequestBody PostsSaveRequestDto requestDto) {
		return service.save(requestDto);
	}

	@PutMapping("/api/v1/posts/{id}")
	public Object update(@PathVariable Long id) {
		return null;
	}

	@DeleteMapping("/api/v1/posts/{id}")
	public void delete(@PathVariable Long id) {
	}
}

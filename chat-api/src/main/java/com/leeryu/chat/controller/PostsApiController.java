package com.leeryu.chat.controller;

import com.leeryu.chat.dto.PostListResponseDto;
import com.leeryu.chat.dto.PostsSaveRequestDto;
import com.leeryu.chat.dto.PostsUpdateRequestDto;
import com.leeryu.chat.service.posts.PostsService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
public class PostsApiController {

	private final PostsService service;

	@GetMapping("/api/v1/posts")
	public List<PostListResponseDto> list() {
		return service.findAllDesc();
	}

	@PostMapping("/api/v1/posts")
	public Long save(@RequestBody PostsSaveRequestDto requestDto) {
		return service.save(requestDto);
	}

	@PutMapping("/api/v1/posts/{id}")
	public Long update(@PathVariable Long id, @RequestBody PostsUpdateRequestDto dto) {
		return service.update(id, dto);
	}

	@DeleteMapping("/api/v1/posts/{id}")
	public void delete(@PathVariable Long id) {
	}
}

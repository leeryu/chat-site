package com.leeryu.chat.service.posts;

import com.leeryu.chat.domain.posts.PostRepository;
import com.leeryu.chat.domain.posts.Posts;
import com.leeryu.chat.dto.PostsResponseDto;
import com.leeryu.chat.dto.PostsSaveRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@RequiredArgsConstructor
@Service
public class PostsService {
	private final PostRepository repository;

	public PostsResponseDto findById(final Long id) {
		final Posts e = repository.findById(id)
				.orElseThrow(() -> new IllegalArgumentException("게시글이 없습니다."));
		return new PostsResponseDto(e);
	}

	@Transactional
	public Long save(PostsSaveRequestDto requestDto) {
		return repository.save(requestDto.toEntity()).getId();
	}

	@Transactional
	public Long update(final Long id, PostsSaveRequestDto requestDto) {
		final Optional<Posts> post = repository.findById(id);
		return 0L;
	}

	@Transactional
	public void delete(final Long id) {
		repository.deleteById(id);
	}
}

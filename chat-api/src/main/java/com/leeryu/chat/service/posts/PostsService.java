package com.leeryu.chat.service.posts;

import com.leeryu.chat.domain.posts.PostRepository;
import com.leeryu.chat.domain.posts.Posts;
import com.leeryu.chat.dto.PostListResponseDto;
import com.leeryu.chat.dto.PostsResponseDto;
import com.leeryu.chat.dto.PostsSaveRequestDto;
import com.leeryu.chat.dto.PostsUpdateRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class PostsService {
	private final PostRepository repository;

	@Transactional(readOnly = true)
	public List<PostListResponseDto> findAllDesc() {
		return repository.findAllDesc().stream()
				.map(PostListResponseDto::new)
				.collect(Collectors.toList());
	}

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
	public Long update(final Long id, PostsUpdateRequestDto requestDto) {
		final Posts posts = repository.findById(id)
				.orElseThrow(() -> new IllegalArgumentException("해당 게시글이 없습니다. id=" + id));

		posts.update(requestDto.getTitle(), requestDto.getContent());

		return id;
	}

	@Transactional
	public void delete(final Long id) {
		repository.deleteById(id);
	}
}

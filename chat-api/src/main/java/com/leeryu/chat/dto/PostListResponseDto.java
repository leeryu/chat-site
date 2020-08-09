package com.leeryu.chat.dto;

import com.leeryu.chat.domain.posts.Posts;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter
public class PostListResponseDto {
	private Long id;
	private String title;
	private String content;
	private String author;
	private LocalDateTime modifiedDate;

	public PostListResponseDto(Posts entity) {
		this.id = entity.getId();
		this.title = entity.getTitle();
		this.content = entity.getContent();
		this.author = entity.getAuthor();
		this.modifiedDate = entity.getModifiedDate();
	}
}

package com.leeryu.chat.dto;

import com.leeryu.chat.domain.posts.Posts;
import lombok.Getter;

@Getter
public class PostsResponseDto {
	private String title;
	private String content;
	private String author;

	public PostsResponseDto(Posts entity) {
		this.title = entity.getTitle();
		this.content = entity.getContent();
		this.author = entity.getAuthor();
	}
}

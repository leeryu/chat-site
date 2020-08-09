package com.leeryu.chat.dto;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
public class PostsResponseDto {
	private Long id;
	private String title;
	private String content;
	private String author;
	private LocalDateTime modifiedDate;
}

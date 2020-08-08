package com.leeryu.chat.controller;

import com.leeryu.chat.domain.posts.PostRepository;
import com.leeryu.chat.domain.posts.Posts;
import com.leeryu.chat.dto.PostsSaveRequestDto;
import org.junit.After;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class PostApiControllerTest {
	@LocalServerPort
	private int port;
	@Autowired
	private TestRestTemplate restTemplate;
	@Autowired
	private PostRepository repository;

	@After
	public void tearDown() {
		repository.deleteAll();
	}

	@Test
	public void 포스트게실글등록() {
		//given
		String title = "title";
		String content = "content";
		final PostsSaveRequestDto requestDto = PostsSaveRequestDto.builder()
				.title(title)
				.content(content)
				.author("sexyuck@gmail.com")
				.build();

		String url = "http://localhost:" + port + "/api/v1/posts";

		//when
		final ResponseEntity<Long> responseEntity = restTemplate.postForEntity(url, requestDto, Long.class);

		//then
		assertThat(responseEntity.getStatusCode()).isEqualTo(HttpStatus.OK);
		assertThat(responseEntity.getBody()).isGreaterThan(0L);

		final List<Posts> posts = repository.findAll();

		assertThat(posts.get(0).getTitle()).isEqualTo(title);
		assertThat(posts.get(0).getContent()).isEqualTo(content);
	}
}

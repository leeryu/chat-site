package com.leeryu.chat.service;

import com.leeryu.chat.dto.PostsResponseDto;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.client.RestTemplate;

import java.io.IOException;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class RestTemplateTest {

	@Autowired
	private RestTemplate restTemplate;
	@Autowired
	private AbstractRestInterface restInterface;

	@Test
	public void restInterface_정상동작확인() throws IOException, ResultFailException {
		final ResponseEntity<List<PostsResponseDto>> listResponseEntity = restInterface.get("http://localhost:10080/api/v1/posts", null, new ParameterizedTypeReference<List<PostsResponseDto>>() {
		});

		assertThat(listResponseEntity.getStatusCode()).isEqualTo(HttpStatus.OK);
		assertThat(listResponseEntity.getBody()).isNotNull();
		assertThat(listResponseEntity.getBody().get(0)).isInstanceOf(PostsResponseDto.class);
	}
}

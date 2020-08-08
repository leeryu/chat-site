package com.leeryu.chat.domain.posts;

import org.junit.After;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
@SpringBootTest
public class PostRepositoryTest {
	@Autowired
	private PostRepository repository;

	@After
	public void cleanUp() {
		repository.deleteAll();
	}

	@Test
	public void 게시글저장_불러오기() {
		//given
		String title = "테스트게시글";
		String content = "테스트 본문";

		repository.save(
				Posts.builder()
					.title(title)
					.content(content)
					.author("sexyuck@gmail.com")
				.build()
		);

		// when
		final List<Posts> posts = repository.findAll();

		// then
		final Posts post = posts.get(0);
		assertThat(post.getTitle().equals(title));
		assertThat(post.getContent().equals(content));
	}
}

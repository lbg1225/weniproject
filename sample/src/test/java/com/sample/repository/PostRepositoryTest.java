package com.sample.repository;

import java.time.LocalDateTime;
import java.util.List;

import com.sample.domain.Post;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;    

@SpringBootTest
public class PostRepositoryTest {

    @Autowired
    PostRepository postRepository;

    @Test
    public void save() {
        // given
        LocalDateTime now = LocalDateTime.of(2020, 8, 12, 0, 0, 0);
        postRepository.save(Post.builder()
                .title("title")
                .content("content")
                .author("author")
                .build());

        // when
        List<Post> postsList = postRepository.findAll();

        //then
        Post posts = postsList.get(0);

        System.out.println(">>>>>>> createdDate=" + posts.getCreatedDate() + ", modifiedDate=" + posts.getModifiedDate());

        // assertThat(posts.getCreatedDate()).isAfter(now);
        // assertThat(posts.getModifiedDate()).isAfter(now);
    }
}
    
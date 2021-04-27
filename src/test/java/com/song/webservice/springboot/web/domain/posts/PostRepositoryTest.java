package com.song.webservice.springboot.web.domain.posts;


import com.song.webservice.springboot.domain.posts.Posts;
import com.song.webservice.springboot.domain.posts.PostsRepository;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.time.LocalDateTime;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@ExtendWith(SpringExtension.class)  // 테스트를 진행할 때, JUnit에 내장된 실행자 외에 다른 실행자(= SpringExtension)를 실행한다. = Spring Boot Test와 JUnit의 연결자 역할
@SpringBootTest
public class PostRepositoryTest {

    @Autowired
    PostsRepository postsRepository;

    @AfterEach
    public void cleanup() {
        postsRepository.deleteAll();
    }

    @Test
    public void postSave_Load() {
        //given
        String title = "Test Post";
        String content = "Test MainText";

        postsRepository.save(Posts.builder()
                .title(title)
                .content(content)
                .author("Song")
                .build()
        );

        //when
         List<Posts> postsList = postsRepository.findAll();

         //then
        Posts posts = postsList.get(0);
        assertThat(posts.getTitle().equals(title));
        assertThat(posts.getContent().equals(content));
    }

    @Test
    public void BaseTimeEntity_insert() {
        //given
        LocalDateTime now = LocalDateTime.of(2021, 4, 27, 0, 0, 0);
        postsRepository.save(Posts.builder()
                .title("title")
                .content("content")
                .author("song")
                .build()
        );

        //when
        List<Posts> postsList = postsRepository.findAll();

        //then
        Posts posts = postsList.get(0);

        System.out.println(">>>>>>>>>>>>createDate = " + posts.getCreatedDate() + ", modifiedDate = " + posts.getModifiedDate());

        assertThat(posts.getCreatedDate()).isAfter(now);
        assertThat(posts.getModifiedDate()).isAfter(now);
    }

}

package com.example.restfulwebservice;

import com.example.restfulwebservice.post.Post;
import com.example.restfulwebservice.post.PostRepository;
import com.example.restfulwebservice.user.User;
import com.example.restfulwebservice.user.UserRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Slf4j
@RequiredArgsConstructor
public class TestInit {

    private final UserRepository userRepository;
    private final PostRepository postRepository;

    @EventListener(ApplicationReadyEvent.class)
    public void dataInit() {
        log.info("test data init");


        User user1 = new User( "user1", new Date(), "1111", "701010-1111111");
        User user2 = new User("user2", new Date(), "2222", "801010-2222222");
        User user3 = new User("user3", new Date(), "3333", "901010-3333333");

        Post post1 = new Post(1L, "My first post", user1);
        Post post2 = new Post(2L, "My second post", user2);
        Post post3 = new Post(3L, "My third post", user2);

        userRepository.save(user1);
        userRepository.save(user2);
        userRepository.save(user3);

        postRepository.save(post1);
        postRepository.save(post2);
        postRepository.save(post3);
    }
}

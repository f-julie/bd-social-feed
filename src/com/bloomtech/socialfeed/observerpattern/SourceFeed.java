package com.bloomtech.socialfeed.observerpattern;

import com.bloomtech.socialfeed.models.Post;
import com.bloomtech.socialfeed.models.User;
import com.bloomtech.socialfeed.repositories.PostRepository;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

//TODO: Implement Observer Pattern
public class SourceFeed {
    private final PostRepository postRepository = new PostRepository();

    private List<Post> posts;
    private List<Observer> observers;

    public SourceFeed() {
        this.posts = new ArrayList<>();
    }

    public void getAllPosts() {
        postRepository.getAllPosts();
    }

    public Post addPost(User user, String body) {
        Post post = new Post(user.getUsername(),
                LocalDateTime.now().toString(),
                body);
        posts = postRepository.addPost(post);

        return post;
    }

    public List<Observer> getObservers() {
        return observers;
    }

    public List<Post> getPosts() {
        return posts;
    }
}

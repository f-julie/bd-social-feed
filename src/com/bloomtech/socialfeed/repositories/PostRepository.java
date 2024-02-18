package com.bloomtech.socialfeed.repositories;

import com.bloomtech.socialfeed.models.Post;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class PostRepository {
    private static final String POST_DATA_PATH = "src/resources/PostData.json";

    public PostRepository() {
    }

    public List<Post> getAllPosts() {
        //TODO: return all posts from the PostData.json file
        return new ArrayList<>();
    }

    public List<Post> findByUsername(String username) {
        return getAllPosts()
                .stream()
                .filter(p -> p.getUsername().equals(username))
                .collect(Collectors.toList());
    }

    public List<Post> addPost(Post post) {
        List<Post> allPosts = new ArrayList<>();
        allPosts.add(post);

        //TODO: Write the new Post data to the PostData.json file

        //TODO: Return an updated list of all posts
        return allPosts;
    }
}

package com.bloomtech.socialfeed.repositories;

import com.bloomtech.socialfeed.helpers.LocalDateTimeAdapter;
import com.bloomtech.socialfeed.models.Post;
import com.bloomtech.socialfeed.models.User;
import com.bloomtech.socialfeed.validators.UserInfoValidator;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.FileWriter;
import java.io.IOException;
import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class PostRepository {
    private static final String POST_DATA_PATH = "src/resources/PostData.json";

    //private static final PostInfoValidator postInfoValidator = new PostInfoValidator();


    public PostRepository() {
    }

    public List<Post> getAllPosts() {
        //TODO: return all posts from the PostData.json file
        // return new ArrayList<>();

        try (Reader reader = Files.newBufferedReader(Paths.get(POST_DATA_PATH))) {
            // Create a Gson instance
            Gson gson = new GsonBuilder()
                    .registerTypeAdapter(LocalDateTime.class, new LocalDateTimeAdapter())
                    .create();

            // Parse JSON data from UserData.json and return the list of users
            Post[] posts = gson.fromJson(reader, Post[].class);
            if (posts == null) {
                return new ArrayList<>();
            }
            return new ArrayList<Post>(Arrays.asList(posts));
        } catch (IOException e) {
            System.out.println("An error occurred while reading from the file: " + e.getMessage());
            return new ArrayList<>();
        }
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
        // Create a Gson instance with pretty printing
        Gson gson = new GsonBuilder()
                .setPrettyPrinting()
                .registerTypeAdapter(LocalDateTime.class, new LocalDateTimeAdapter())
                .create();

        // Convert the allPosts list to JSON
        String json = gson.toJson(allPosts);

        // Write the JSON to PostData.json
        try (FileWriter file = new FileWriter(POST_DATA_PATH)) {
            file.write(json);
        } catch (IOException e) {
            System.out.println("An error occurred while writing to the file: " + e.getMessage());
        }

        //TODO: Return an updated list of all posts
        return allPosts;
    }
}

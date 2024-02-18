package com.bloomtech.socialfeed;

import com.bloomtech.socialfeed.helpers.LocalDateTimeAdapter;
import com.bloomtech.socialfeed.models.Post;
import com.bloomtech.socialfeed.models.User;
import com.bloomtech.socialfeed.repositories.PostRepository;
import com.bloomtech.socialfeed.repositories.UserRepository;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.time.LocalDateTime;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class MT03_JsonReadWrite {
    UserRepository userRepository = new UserRepository();
    PostRepository postRepository = new PostRepository();

    @BeforeEach
    public void init() {
        SeedData.run();
    }

    @Test
    public void checkUserData_expectCorrectJson() throws IOException {
        List<User> userList = userRepository.getAllUsers();
        Gson gson = new GsonBuilder().setPrettyPrinting().create();

        String expectedString = gson.toJson(userList) + "\n";

        File userFile = new File(App.USER_FILE_PATH);
        BufferedReader br = new BufferedReader(new FileReader(userFile));

        String actualString = "";
        String line;
        while ((line = br.readLine()) != null) {
            actualString += line + "\n";
        }

        br.close();

        assertEquals(actualString, expectedString);
    }

    @Test
    public void checkPostData_expectCorrectJson() throws IOException {
        List<Post> postList = postRepository.getAllPosts();
        Gson gson = new GsonBuilder()
                .registerTypeAdapter(LocalDateTime.class, new LocalDateTimeAdapter())
                .setPrettyPrinting()
                .create();

        String expectedString = gson.toJson(postList) + "\n";

        File postFile = new File(App.POST_FILE_PATH);
        BufferedReader br = new BufferedReader(new FileReader(postFile));

        String actualString = "";
        String line;
        while ((line = br.readLine()) != null) {
            actualString += line + "\n";
        }

        br.close();

        assertEquals(actualString, expectedString);
    }
}

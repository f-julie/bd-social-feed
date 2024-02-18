package com.bloomtech.socialfeed;

import com.bloomtech.socialfeed.models.Role;
import com.bloomtech.socialfeed.models.User;
import com.bloomtech.socialfeed.repositories.UserRepository;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class SeedData {
    private static final UserRepository userRepository = new UserRepository();

    public static void run() {
        File userDataFile = new File(App.USER_FILE_PATH);
        userDataFile.delete();
        File postDataFile = new File(App.POST_FILE_PATH);
        postDataFile.delete();

        try {
            userDataFile.createNewFile();
            postDataFile.createNewFile();
        } catch (IOException err) {
            throw new RuntimeException("Failed to create data file");
        }

        User leader = new User();
            leader.setUsername("Leader");
            leader.setEmail("leader@email.com");
            leader.setPassword("TestPass123");
            leader.setRole(Role.ADMIN);

        User follower = new User();
            follower.setUsername("Follower");
            follower.setEmail("follower@email.com");
            follower.setPassword("TestPass123");
            follower.setRole(Role.USER);

        User loner = new User();
            loner.setUsername("Loner");
            loner.setEmail("loner@email.com");
            loner.setPassword("TestPass123");
            loner.setRole(Role.DATA);

        leader.follow(follower.getUsername());

        follower.follow(leader.getUsername());
        follower.follow(loner.getUsername());

        List<User> userList = new ArrayList<>();
        userList.add(leader);
        userList.add(follower);
        userList.add(loner);

        userRepository.save(leader);
        userRepository.save(follower);
        userRepository.save(loner);

        App.sourceFeed.addPost(leader, "Welcome everyone!");
        App.sourceFeed.addPost(follower, "I am so excited to hear everything leader has to say!");
        App.sourceFeed.addPost(loner, "I am not interested in what anyone has to say but myself");
    }
}

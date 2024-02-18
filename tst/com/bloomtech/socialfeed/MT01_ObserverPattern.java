package com.bloomtech.socialfeed;

import com.bloomtech.socialfeed.models.User;
import com.bloomtech.socialfeed.observerpattern.OUserFeed;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;


public class MT01_ObserverPattern {
    @BeforeEach
    public void init() {
        SeedData.run();
    }

    @Test
    public void createObserver_attachesToSource() {
        OUserFeed userFeed = new User().getUserFeed();
        assertTrue(App.sourceFeed.getObservers().contains(userFeed));
    }

    @Test
    public void createPost_andExpectItToBeInTheUsersFeed() {
        User newUser = new User();
        newUser.setUsername("NewUser");
        newUser.follow("NewUser");
        App.sourceFeed.addPost(newUser, "new post");
        assertEquals(1, newUser.getUserFeed().getFeed().size());
    }

    @Test
    public void createPostfromUserNotFollowed_andExpectItNotToBeInTheUsersFeed() {
        User poster = new User();
        poster.setUsername("Poster");
        User user = new User();
        user.setUsername("User");
        App.sourceFeed.addPost(poster, "new post");
        assertEquals(0, user.getUserFeed().getFeed().size());
    }
}

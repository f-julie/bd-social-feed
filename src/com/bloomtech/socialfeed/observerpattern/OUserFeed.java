package com.bloomtech.socialfeed.observerpattern;

import com.bloomtech.socialfeed.App;
import com.bloomtech.socialfeed.models.Post;
import com.bloomtech.socialfeed.models.User;

import java.util.List;

//TODO: Implement Observer Pattern
public class OUserFeed {
    private User user;
    private List<Post> feed;

    public OUserFeed(User user) {
        this.user = user;
        //TODO: update OUserFeed in constructor after implementing observer pattern
    }

    public User getUser() {
        return user;
    }

    public List<Post> getFeed() {
        return feed;
    }
}

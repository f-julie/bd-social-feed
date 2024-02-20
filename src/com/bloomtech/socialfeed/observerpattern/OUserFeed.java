package com.bloomtech.socialfeed.observerpattern;

import com.bloomtech.socialfeed.App;
import com.bloomtech.socialfeed.models.Post;
import com.bloomtech.socialfeed.models.User;

import java.util.ArrayList;
import java.util.List;

//TODO: Implement Observer Pattern
public class OUserFeed implements Observer {
    private User user;
    private List<Post> feed;

    public OUserFeed(User user) {
        this.user = user;
        //TODO: update OUserFeed in constructor after implementing observer pattern
        this.feed = new ArrayList<>();
        App.sourceFeed.attach(this); // attach this observer to the SourceFeed
    }

    public User getUser() {
        return user;
    }

    public List<Post> getFeed() {
        return feed;
    }

    @Override
    public void update() {
        if (user != null) {
            List<Post> posts = App.sourceFeed.getPosts();
            for (Post p : posts) {
                for (String username : user.getFollowing()) {
                    if (username.equals(p.getUsername())) {
                        this.feed.add(p);
                    }
                }
            }
        }
    }
}

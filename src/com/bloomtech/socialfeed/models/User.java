package com.bloomtech.socialfeed.models;

import com.bloomtech.socialfeed.App;
import com.bloomtech.socialfeed.observerpattern.OUserFeed;

import java.util.ArrayList;
import java.util.List;

public class User {
    private String username;
    private String email;
    private String password;
    private Role role;
    private List<String> following;

    //transient properties are not written to JSON
    private transient OUserFeed userFeed;

    public User() {
        following = new ArrayList<>();
        userFeed = new OUserFeed(this);
    }

    public String getUsername() {
        return username;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    public Role getRole() {
        return role;
    }

    public OUserFeed getUserFeed() {
        return userFeed;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    public void setUserFeed(OUserFeed userFeed) {
        this.userFeed = userFeed;
    }

    public List<String> getFollowing() {
        return following;
    }

    public void setFollowing(List<String> following) {
        this.following = following;
    }

    @Override
    public String toString() {
        return "User{" +
                "username='" + username + '\'' +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", role=" + role +
                '}';
    }

    public void follow(String usernameToFollow) {
        following.add(usernameToFollow);
    }
}

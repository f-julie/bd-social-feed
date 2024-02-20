package com.bloomtech.socialfeed.models;

import com.bloomtech.socialfeed.helpers.LocalDateTimeAdapter;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.time.LocalDateTime;

public class Post {
    private String username;
    private LocalDateTime postedon; //TODO: Convert type to LocalDateTime
    private String body;

    public Post() {
    }

    public Post(String username, LocalDateTime postedon, String body) {
        this.username = username;
        this.postedon = postedon;
        this.body = body;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public LocalDateTime getPostedon() {
        Gson gson = new GsonBuilder()
                .registerTypeAdapter(LocalDateTime.class, new LocalDateTimeAdapter())
                .create();
        return postedon;
    }

    public void setPostedon(LocalDateTime postedon) {
        Gson gson = new GsonBuilder()
                .registerTypeAdapter(LocalDateTime.class, new LocalDateTimeAdapter())
                .create();
        this.postedon = postedon;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    @Override
    public String toString() {
        return "Post{" +
                "username='" + username + '\'' +
                ", postedon='" + postedon + '\'' +
                ", body='" + body + '\'' +
                '}';
    }
}

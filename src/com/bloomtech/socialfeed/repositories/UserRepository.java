package com.bloomtech.socialfeed.repositories;

import com.bloomtech.socialfeed.helpers.LocalDateTimeAdapter;
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

public class UserRepository {
    private static final String USER_DATA_PATH = "src/resources/UserData.json";

    private static final UserInfoValidator userInfoValidator = new UserInfoValidator();

    public UserRepository() {
    }

    public List<User> getAllUsers() {
        //List<User> allUsers = new ArrayList<>();
        //TODO: return parsed list of Users from UserData.json
        //return allUsers;

        try (Reader reader = Files.newBufferedReader(Paths.get(USER_DATA_PATH))) {
            // Create a Gson instance
            Gson gson = new GsonBuilder()
                    .registerTypeAdapter(LocalDateTime.class, new LocalDateTimeAdapter())
                    .create();

            // Parse JSON data from UserData.json and return the list of users
            User[] users = gson.fromJson(reader, User[].class);
            if (users == null) {
                return new ArrayList<>();
            }
            return new ArrayList<User>(Arrays.asList(users));
        } catch (IOException e) {
            System.out.println("An error occurred while reading from the file: " + e.getMessage());
            return new ArrayList<>();
        }
    }

    public Optional<User> findByUsername(String username) {
        return getAllUsers()
                .stream()
                .filter(u -> u.getUsername().equals(username))
                .findFirst();
    }

    public void save(User user) {
        List<User> allUsers = getAllUsers();
        if (allUsers.isEmpty()) {
            allUsers = new ArrayList<>();
        }
        Optional<User> existingUser = allUsers.stream()
                .filter(u -> u.getUsername().equals(user.getUsername()))
                .findFirst();

        if (!existingUser.isEmpty()) {
            throw new RuntimeException("User with name: " + user.getUsername() + " already exists!");
        }
        allUsers.add(user);
        //TODO: Write allUsers to UserData.json

        // Create a Gson instance with pretty printing
        Gson gson = new GsonBuilder()
                .setPrettyPrinting()
                .registerTypeAdapter(LocalDateTime.class, new LocalDateTimeAdapter())
                .create();

        // Convert the allUsers list to JSON
        String json = gson.toJson(allUsers);

        // Write the JSON to UserData.json
        try (FileWriter file = new FileWriter(USER_DATA_PATH)) {
            file.write(json);
        } catch (IOException e) {
            System.out.println("An error occurred while writing to the file: " + e.getMessage());
        }
    }
}

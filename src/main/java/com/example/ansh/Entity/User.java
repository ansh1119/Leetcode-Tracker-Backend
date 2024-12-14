package com.example.ansh.Entity;


import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class User {

    @Id
    private String username;
    private String language;
    private UserDetails userDetails;

    public UserDetails getUserDetails() {
        return userDetails;
    }

    public void setUserDetails(UserDetails userDetails) {
        this.userDetails = userDetails;
    }

    public User(){

    }

    public User(String username, String language, UserDetails userDetails) {
        this.language=language;
        this.username = username;
        this.userDetails=userDetails;
    }

    public String getUsername() {
        return username;
    }

    public String getLanguage() {
        return language;
    }

    public String setLanguage() {
        return language;
    }

    public void setUsername(String username) {
        this.username = username;
    }
}

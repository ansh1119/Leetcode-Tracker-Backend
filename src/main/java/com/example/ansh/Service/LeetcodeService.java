package com.example.ansh.Service;


import com.example.ansh.Entity.User;
import com.example.ansh.Entity.UserDetails;
import com.example.ansh.Repository.LeetcodeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.HttpServerErrorException;
import org.springframework.web.client.RestTemplate;

import java.sql.SQLOutput;
import java.time.Instant;
import java.time.LocalDate;
import java.time.ZoneId;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;

@Service
public class LeetcodeService {

    private final RestTemplate restTemplate;

    @Autowired
    public LeetcodeService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    @Autowired
    LeetcodeRepository leetcodeRepository;

    public User getLeetCodeStats(String username,String language) {
        // Ensure username is not null or empty
        if (username == null || username.trim().isEmpty()) {
            System.out.println("username null aaya h");
            throw new IllegalArgumentException("Username cannot be null or empty");
        }

        // Define the URL to call the API (replace <YOUR_USERNAME> with actual username)
        String url = "https://leetcode-stats-api.herokuapp.com/" + username;
        System.out.println(url);

        try {
            // Make a GET request to the API and map the response to UserDetails object
            ResponseEntity<UserDetails> response = restTemplate.getForEntity(url, UserDetails.class);

            System.out.println(response.getBody());
            User user = new User(username, language, response.getBody());
            // Return the response body
            leetcodeRepository.save(user);
            return user;

        } catch (HttpClientErrorException | HttpServerErrorException e) {
            // Handle HTTP errors (4xx, 5xx responses)
            System.out.println("Error during API call: " + e.getStatusCode());
            return null;
        } catch (Exception e) {
            // Handle any other unexpected errors
            System.out.println("Unexpected error: " + e.getMessage());
            return null;
        }
    }


    public List<Boolean> attemptedLast5Days(String username, String language) {
        User user = getLeetCodeStats(username, language);
        UserDetails userDetails = null;
        if (user != null) {
            userDetails = user.getUserDetails();
        }

        Map<Long, Integer> submissionMap = null;
        if (userDetails != null) {
            submissionMap = userDetails.getSubmissionCalendar();
        }

        // Prepare a list to hold the boolean values for the last 5 days
        List<Boolean> submissionStatus = new ArrayList<>(Collections.nCopies(5, false));

        if (submissionMap != null) {
            try {
                // Get today's date in UTC
                LocalDate today = Instant.now().atZone(ZoneId.of("UTC")).toLocalDate();

                // Iterate through the submission map to check if any key matches the last 5 days
                for (Map.Entry<Long, Integer> entry : submissionMap.entrySet()) {
                    // Convert the timestamp to LocalDate
                    LocalDate submissionDate = Instant.ofEpochSecond(entry.getKey())
                            .atZone(ZoneId.of("UTC"))
                            .toLocalDate();

                    // Calculate the difference in days between submissionDate and today
                    long daysDifference = ChronoUnit.DAYS.between(submissionDate, today);

                    // Check if the submission falls within the last 5 days (0 to 4 days difference)
                    if (daysDifference >= 0 && daysDifference < 5) {
                        // Mark the corresponding day as true
                        submissionStatus.set((int) daysDifference, true);
                    }
                }
            } catch (Exception e) {
                System.out.println(e.toString());
            }
        }

        return submissionStatus;
    }


    public List<User> getUsers() {
        return leetcodeRepository.findAll();
    }

    public List<User> getUsersByLanguage(String language) {
        return leetcodeRepository.findByLanguage(language);
    }



    public void deleteUser(String username) {
        User user=leetcodeRepository.findByUsername(username).orElse(null);
        if (user != null) {
            // Safe to call getUserDetails() method
            leetcodeRepository.delete(user);
        } else {
            return;
        }
    }
}

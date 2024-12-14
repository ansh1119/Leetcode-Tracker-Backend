package com.example.ansh.Controller;


import com.example.ansh.Entity.User;
import com.example.ansh.Service.LeetcodeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class LeetcodeController {

    @Autowired
    LeetcodeService leetcodeService;

    @GetMapping("/new-user/{language}/{username}")
    public User addUser(@PathVariable String language,@PathVariable String username){
        try {
            return leetcodeService.getLeetCodeStats(username,language);

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }


    @GetMapping("/last5days/{language}/{username}")
    public List<Boolean> submissionLast5Days(@PathVariable String language, @PathVariable String username) {
        return leetcodeService.attemptedLast5Days(username, language);
    }


    @GetMapping("/users")
    public List<User> getUsers(){
        return leetcodeService.getUsers();
    }

    @PostMapping("/delete/{username}")
    public void deleteUser(@PathVariable String username){
        leetcodeService.deleteUser(username);
    }
}

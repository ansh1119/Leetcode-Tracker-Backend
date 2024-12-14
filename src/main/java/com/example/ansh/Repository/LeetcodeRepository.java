package com.example.ansh.Repository;

import com.example.ansh.Entity.User;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface LeetcodeRepository extends MongoRepository<User,String> {
    Optional<User> findByUsername(String username);
    List<User> findByLanguage(String language);
}
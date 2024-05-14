package com.example.BirdWatcherAPI.services;

import com.example.BirdWatcherAPI.items.User;
import com.example.BirdWatcherAPI.repositories.UserRepository;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;

@Service
public class UserService {
    private UserRepository repo;

    public UserService(UserRepository repo) {
        this.repo = repo;
    }


    public User getUserByUsername(String username) {
        if(repo.existsByUsername(username)){
            return repo.findByUsername(username);
        }
        return null;
    }
}

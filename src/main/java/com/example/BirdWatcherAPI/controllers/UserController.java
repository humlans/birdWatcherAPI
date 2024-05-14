package com.example.BirdWatcherAPI.controllers;

import com.example.BirdWatcherAPI.items.User;
import com.example.BirdWatcherAPI.services.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/user")
public class UserController {
    private UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/get-user")
    public ResponseEntity<User> getUserByUsername(String username) {
        User user = userService.getUserByUsername(username);
        if(user != null) {
            return ResponseEntity.ok(user);
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
    }

    @GetMapping("/login")
    public ResponseEntity<User> loginUser(String username, String password) {
        User user = userService.getUserByUsername(username);
        if(user != null) {
            if(password.equals(user.getPassword())) {
                return ResponseEntity.ok(user);
            }
            else {
                return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
            }
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
    }

    @PostMapping("/create-user")
    public ResponseEntity<Boolean> createUser(User user) {
        return ResponseEntity.badRequest().body(false);
    }

}

package com.example.BirdWatcherAPI.controllers;

import com.example.BirdWatcherAPI.items.Notification;
import com.example.BirdWatcherAPI.items.Sighting;
import com.example.BirdWatcherAPI.services.NotificationService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/notification")
public class NotificationController {

    private NotificationService notificationService;

    public NotificationController(NotificationService notificationService) {
        this.notificationService = notificationService;
    }

    // Don't forget to change this in case of not found, the responsebody should change then
    // Make sure that the username is a username that exists before doing this
    @GetMapping("/get-by-user")
    public ResponseEntity<ArrayList<Notification>> getSightingsByUser(String username) {
        return ResponseEntity.ok(notificationService.getNotificationsByUsername(username));
    }

    @GetMapping("/get-last-id")
    public ResponseEntity<Integer> getLastId() {
        int lastId = notificationService.getLastId();
        if (lastId == Integer.MIN_VALUE) {
            return ResponseEntity.badRequest().body(lastId);
        }
        return ResponseEntity.status(HttpStatus.OK).body(lastId);
    }

    @PostMapping("/add-new")
    public ResponseEntity<Boolean> addNewNotification(@RequestBody Notification notification) {
        boolean success = notificationService.addNewNotification(notification);
        if(success) {
            return ResponseEntity.ok(true);
        }
        return ResponseEntity.badRequest().body(false);
    }


}

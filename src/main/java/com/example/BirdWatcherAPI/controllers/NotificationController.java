package com.example.BirdWatcherAPI.controllers;

import com.example.BirdWatcherAPI.items.BirdSpecies;
import com.example.BirdWatcherAPI.items.Notification;
import com.example.BirdWatcherAPI.services.NotificationsService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/notification")
public class NotificationController {
    private NotificationsService notificationsService;

    public NotificationController(NotificationsService notificationsService) {
        this.notificationsService = notificationsService;
    }

    @GetMapping("/get-all")
    public ResponseEntity<ArrayList<Notification>> getAllNotifications() {
        return ResponseEntity.ok(notificationsService.getNotifications());
    }

}

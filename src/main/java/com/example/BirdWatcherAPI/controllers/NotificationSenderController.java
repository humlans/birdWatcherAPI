package com.example.BirdWatcherAPI.controllers;


import com.example.BirdWatcherAPI.items.NotificationListener;
import com.example.BirdWatcherAPI.items.NotificationSender;
import com.example.BirdWatcherAPI.services.NotificationSenderService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/notification-sender")
public class NotificationSenderController {
    private NotificationSenderService notificationSenderService;

    public NotificationSenderController(NotificationSenderService notificationSenderService) {
        this.notificationSenderService = notificationSenderService;
    }

    @GetMapping("/get-by-id")
    public ResponseEntity<NotificationSender> getNotificationSenderById(int id) {
        NotificationSender notificationSender = notificationSenderService.getNotificationSenderById(id);
        if(notificationSender != null) {
            return ResponseEntity.ok(notificationSender);
        }
        return ResponseEntity.badRequest().body(null);
    }

    @PostMapping("/add-new")
    public ResponseEntity<Boolean> addNotificationSender(@RequestBody NotificationSender notificationSender) {
        boolean success = notificationSenderService.addNewNotificationSender(notificationSender);
        if(success) {
            return ResponseEntity.status(HttpStatus.CREATED).body(true);
        }
        return ResponseEntity.badRequest().body(false);
    }

    @PutMapping("/edit")
    public ResponseEntity<Boolean> editNotificationSender(@RequestBody NotificationSender notificationSender) {
        NotificationSender notificationSenders =notificationSender;
        boolean success = notificationSenderService.editNotificationSender(notificationSender);
        if(success) {
            return ResponseEntity.ok(true);
        }
        return ResponseEntity.badRequest().body(false);
    }


}

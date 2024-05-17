package com.example.BirdWatcherAPI.controllers;

import com.example.BirdWatcherAPI.items.NotificationListener;
import com.example.BirdWatcherAPI.services.ListenerService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/notification-listener")
public class ListenerController {
    private ListenerService listenerService;

    public ListenerController(ListenerService listenerService) {
        this.listenerService = listenerService;
    }

    @GetMapping("/get-by-id")
    public ResponseEntity<NotificationListener> getById(int id) {
        NotificationListener listener = listenerService.getSightingById(id);
        if (listener != null) {
            return ResponseEntity.ok(listener);
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
    }

    @GetMapping("/get-last-id")
    public ResponseEntity<Integer> getLastId() {
        int lastId = listenerService.getLastId();
        if (lastId == Integer.MIN_VALUE) {
            return ResponseEntity.badRequest().body(lastId);
        }
        return ResponseEntity.status(HttpStatus.OK).body(lastId);
    }

    @PostMapping("/add-new")
    public ResponseEntity<Boolean> addNewNotificationListener(@RequestBody NotificationListener listener) {
        boolean success = listenerService.addNewListener(listener);
        if(success) {
            return ResponseEntity.ok(true);
        }
        return ResponseEntity.badRequest().body(false);
    }
    @GetMapping("/get-by-user")
    public ResponseEntity<ArrayList<NotificationListener>> getNotificationListenerByUsername(String username) {
        ArrayList<NotificationListener> listeners = listenerService.getListenersByUsername(username);
        if (listeners.isEmpty()) {
            return ResponseEntity.badRequest().body(new ArrayList<>());
        }
        return ResponseEntity.ok(listeners);
    }

    @DeleteMapping("/delete")
    public ResponseEntity<Boolean> deleteNotificationListener(int id) {
        boolean success = listenerService.deleteListenerById(id);
        if (success) {
            // Delete request succeeded.
            return ResponseEntity.status(HttpStatus.OK).body(true) ;
        }
        // Delete request failed.
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(false);
    }
}

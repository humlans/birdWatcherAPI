package com.example.BirdWatcherAPI.services;

import com.example.BirdWatcherAPI.items.Notification;
import com.example.BirdWatcherAPI.repositories.NotificationRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class NotificationService {
    private NotificationRepository repo;

    public NotificationService(NotificationRepository repo) {
        this.repo = repo;
    }

    public ArrayList<Notification> getNotificationsByUsername(String username) {
        return (ArrayList<Notification>) repo.getNotificationsByUser(username);
    }

    public int getLastId() {
        return repo.findAll().getLast().getId();
    }

    public boolean addNewNotification(Notification notification) {
        repo.save(notification);
        return true;
    }
}

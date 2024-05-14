package com.example.BirdWatcherAPI.services;

import com.example.BirdWatcherAPI.items.BirdSpecies;
import com.example.BirdWatcherAPI.items.Notification;
import com.example.BirdWatcherAPI.repositories.NotificationRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class NotificationsService {
    private NotificationRepository repo;

    public NotificationsService(NotificationRepository repo) {
        this.repo = repo;
    }

    public ArrayList<Notification> getNotifications() {
        return (ArrayList<Notification>) repo.findAll();
    }
}

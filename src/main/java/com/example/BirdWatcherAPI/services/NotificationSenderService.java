package com.example.BirdWatcherAPI.services;

import com.example.BirdWatcherAPI.items.NotificationSender;
import com.example.BirdWatcherAPI.repositories.NotificationSenderRepository;
import org.springframework.stereotype.Service;

@Service
public class NotificationSenderService {
    private NotificationSenderRepository repo;

    public NotificationSenderService(NotificationSenderRepository repo) {
        this.repo = repo;
    }

    public NotificationSender getNotificationSenderById(int id) {
        if(repo.existsById(id)){
            return repo.findByBirdSpeciesId(id);
        }
        return null;
    }


    public boolean addNewNotificationSender(NotificationSender notificationSender) {
        repo.save(notificationSender);
        return true;
    }

    public boolean editNotificationSender(NotificationSender notificationSender) {
        if(repo.existsById(notificationSender.getId())) {
            repo.save(notificationSender);
            return true;
        }
        return false;
    }

}

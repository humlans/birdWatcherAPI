package com.example.BirdWatcherAPI.services;

import com.example.BirdWatcherAPI.items.NotificationListener;
import com.example.BirdWatcherAPI.repositories.ListenerRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class ListenerService {
    private ListenerRepository repo;

    public ListenerService(ListenerRepository repo) {
        this.repo = repo;
    }


    public int getLastId() {
        return repo.findAll().getLast().getId();
    }

    public boolean addNewListener(NotificationListener listener) {
        repo.save(listener);
        listener.setId(listener.getId());
        return true;
    }

    public NotificationListener getSightingById(int id) {
        if(repo.existsById(id)){
            return repo.findById(id);
        }
        return null;
    }

    public ArrayList<NotificationListener> getListenersByUsername(String username) {
        return (ArrayList<NotificationListener>) repo.getNotificationListenersByUser(username);
    }

    public boolean deleteListenerById(int id) {
        if(repo.existsById(id)){
            repo.deleteById(id);
            return true;
        }
        return false;
    }

}

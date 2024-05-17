package com.example.BirdWatcherAPI.repositories;

import com.example.BirdWatcherAPI.items.Notification;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface NotificationRepository extends JpaRepository<Notification, Integer> {

    @Query(value = "SELECT * FROM notifications WHERE username = ?", nativeQuery = true)
    public List<Notification> getNotificationsByUser(String username);
}

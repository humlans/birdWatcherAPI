package com.example.BirdWatcherAPI.repositories;

import com.example.BirdWatcherAPI.items.NotificationListener;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ListenerRepository extends JpaRepository<NotificationListener, Integer> {

    NotificationListener findById(int id);

    @Query(value = "SELECT * FROM notification_listeners WHERE subscriber_username = ?", nativeQuery = true)
    public List<NotificationListener> getNotificationListenersByUser(String username);
}

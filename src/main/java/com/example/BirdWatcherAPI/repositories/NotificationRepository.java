package com.example.BirdWatcherAPI.repositories;

import com.example.BirdWatcherAPI.items.Notification;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface NotificationRepository extends JpaRepository<Notification, Integer> {

}

package com.example.BirdWatcherAPI.repositories;

import com.example.BirdWatcherAPI.items.NotificationSender;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface NotificationSenderRepository extends JpaRepository<NotificationSender, Integer> {

    NotificationSender findByBirdSpeciesId(int id);
}

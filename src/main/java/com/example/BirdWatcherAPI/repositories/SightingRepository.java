package com.example.BirdWatcherAPI.repositories;

import com.example.BirdWatcherAPI.items.Sighting;
import com.example.BirdWatcherAPI.items.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SightingRepository extends JpaRepository<Sighting, Integer> {
    boolean existsById(int id);
    Sighting findById(int id);

    @Query(value = "SELECT * FROM sightings WHERE username = ?", nativeQuery = true)
    public List<Sighting> getSightingsByUser(String username);
}

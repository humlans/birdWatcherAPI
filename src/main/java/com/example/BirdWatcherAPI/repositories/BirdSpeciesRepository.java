package com.example.BirdWatcherAPI.repositories;

import com.example.BirdWatcherAPI.items.BirdSpecies;
import com.example.BirdWatcherAPI.items.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BirdSpeciesRepository extends JpaRepository<BirdSpecies, Integer> {
    boolean existsByEnglishName(String englishName);
    BirdSpecies findByEnglishName(String englishName);
}

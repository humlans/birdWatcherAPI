package com.example.BirdWatcherAPI.services;

import com.example.BirdWatcherAPI.items.BirdSpecies;
import com.example.BirdWatcherAPI.items.Sighting;
import com.example.BirdWatcherAPI.items.User;
import com.example.BirdWatcherAPI.repositories.SightingRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class SightingService {
    private SightingRepository repo;

    public SightingService(SightingRepository repo) {
        this.repo = repo;
    }

    public ArrayList<Sighting> getSightings() {
        return (ArrayList<Sighting>) repo.findAll();
    }

    public Sighting getSightingById(int id) {
        if(repo.existsById(id)){
            return repo.findById(id);
        }
        return null;
    }

    public ArrayList<Sighting> getSightingByUsername(String username) {
        return (ArrayList<Sighting>) repo.getSightingsByUser(username);
    }

    public boolean addNewSighting(Sighting sighting) {
        Sighting addedSighting = repo.save(sighting);
        sighting.setId(sighting.getId());
        return true;
    }

    public boolean editSighting(Sighting sighting) {
        if(repo.existsById(sighting.getId())) {
            repo.save(sighting);
            return true;
        }
        return false;
    }

    public int getLastId() {
        return repo.findAll().getLast().getId();
    }

    public boolean deleteRecipeById(int id) {
        if(repo.existsById(id)){
            repo.deleteById(id);
            return true;
        }
        return false;
    }
}

package com.example.BirdWatcherAPI.services;

import com.example.BirdWatcherAPI.items.BirdSpecies;
import com.example.BirdWatcherAPI.repositories.BirdSpeciesRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class BirdSpeciesService {
    private BirdSpeciesRepository repo;

    public BirdSpeciesService(BirdSpeciesRepository repo) {
        this.repo = repo;
    }

    public BirdSpecies getBirdSpeciesByEnglishName(String englishName) {
        if(repo.existsByEnglishName(englishName)) {
            return repo.findByEnglishName(englishName);
        }
        return null;
    }

    public ArrayList<BirdSpecies> getBirdSpecies() {
        return (ArrayList<BirdSpecies>) repo.findAll();
    }

    public boolean addNewBirdSpecies(BirdSpecies birdSpecies) {
        BirdSpecies addedBirdSpecies = repo.save(birdSpecies);
        birdSpecies.setId(birdSpecies.getId());
        return true;
    }

    public int getLastId() {
        return repo.findAll().getLast().getId();
    }

    public boolean editBirdSpecies(BirdSpecies birdSpecies) {
        if(repo.existsById(birdSpecies.getId())) {
            repo.save(birdSpecies);
            return true;
        }
        return false;
    }

    public boolean deleteBirdSpeciesById(int id) {
        if(repo.existsById(id)){
            repo.deleteById(id);
            return true;
        }
        return false;
    }
}

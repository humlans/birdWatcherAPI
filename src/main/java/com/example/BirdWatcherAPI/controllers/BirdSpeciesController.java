package com.example.BirdWatcherAPI.controllers;

import com.example.BirdWatcherAPI.items.BirdSpecies;
import com.example.BirdWatcherAPI.services.BirdSpeciesService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/bird-species")
public class BirdSpeciesController {
    private BirdSpeciesService birdSpeciesService;

    public BirdSpeciesController(BirdSpeciesService birdSpeciesService) {
        this.birdSpeciesService = birdSpeciesService;
    }

    @GetMapping("/get-all")
    public ResponseEntity<ArrayList<BirdSpecies>> getAllBirdSpecies() {
        return ResponseEntity.ok(birdSpeciesService.getBirdSpecies());
    }

    @GetMapping("/get-by-english-name")
    public ResponseEntity<BirdSpecies> getBirdSpeciesByEnglishName(String englishName) {
        BirdSpecies birdSpecies = birdSpeciesService.getBirdSpeciesByEnglishName(englishName);
        if(birdSpecies != null) {
            return ResponseEntity.ok(birdSpecies);
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
    }

    @PostMapping("/add-new")
    public ResponseEntity<Boolean> addBirdSpecies(@RequestBody BirdSpecies birdSpecies) {
        boolean success = birdSpeciesService.addNewBirdSpecies(birdSpecies);
        if (success) {
            return ResponseEntity.status(HttpStatus.CREATED).body(true);
        }
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(false);
    }

    @GetMapping("/get-last-id")
    public ResponseEntity<Integer> getLastId() {
        int lastId = birdSpeciesService.getLastId();
        if (lastId == Integer.MIN_VALUE) {
            return ResponseEntity.badRequest().body(lastId);
        }
        return ResponseEntity.status(HttpStatus.OK).body(lastId);
    }

    @PutMapping("/edit")
    public ResponseEntity<Boolean> editBirdSpecies(@RequestBody BirdSpecies birdSpecies) {
        boolean success = birdSpeciesService.editBirdSpecies(birdSpecies);
        if (success) {
            return ResponseEntity.ok(true);
        }
        return ResponseEntity.badRequest().body(false);
    }

    @DeleteMapping("/delete")
    public ResponseEntity<Boolean> deleteBirdSpecies(int id){
        boolean success = birdSpeciesService.deleteBirdSpeciesById(id);
        if (success) {
            // Delete request succeeded.
            return ResponseEntity.status(HttpStatus.OK).body(true) ;
        }
        // Delete request failed.
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(false);
    }
}

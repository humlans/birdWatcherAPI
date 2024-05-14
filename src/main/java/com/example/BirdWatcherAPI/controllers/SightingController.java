package com.example.BirdWatcherAPI.controllers;

import com.example.BirdWatcherAPI.items.BirdSpecies;
import com.example.BirdWatcherAPI.items.Sighting;
import com.example.BirdWatcherAPI.items.User;
import com.example.BirdWatcherAPI.services.SightingService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/sighting")
public class SightingController {
    private SightingService sightingService;

    public SightingController(SightingService sightingService) {
        this.sightingService = sightingService;
    }

    @GetMapping("/get-all")
    public ResponseEntity<ArrayList<Sighting>> getAllSightings() {
        return ResponseEntity.ok(sightingService.getSightings());
    }


    @GetMapping("/get-by-id")
    public ResponseEntity<Sighting> getSightingById(int id) {
        Sighting foundSighting = sightingService.getSightingById(id);
        if (foundSighting != null) {
            return ResponseEntity.ok(foundSighting);
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
    }


    // Don't forget to change this in case of not found, the responsebody should change then
    // Make sure that the username is a username that exists before doing this
    @GetMapping("/get-by-user")
    public ResponseEntity<ArrayList<Sighting>> getSightingsByUser(String username) {
        return ResponseEntity.ok(sightingService.getSightingByUsername(username));
    }


    @PostMapping("/add-new-sighting")
    public ResponseEntity<Boolean> addSighting(@RequestBody Sighting sighting) {
        boolean success = sightingService.addNewSighting(sighting);
        if (success) {
            return ResponseEntity.status(HttpStatus.CREATED).body(true);
        }
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(false);
    }

    @PutMapping("/edit")
    public ResponseEntity<Boolean> editSighting(@RequestBody Sighting sighting) {
        boolean success = sightingService.editSighting(sighting);
        if (success) {
            return ResponseEntity.ok(true);
        }
        return ResponseEntity.badRequest().body(false);
    }

    @GetMapping("/get-last-id")
    public ResponseEntity<Integer> getLastId() {
        int lastId = sightingService.getLastId();
        if (lastId == Integer.MIN_VALUE) {
            return ResponseEntity.badRequest().body(lastId);
        }
        return ResponseEntity.status(HttpStatus.OK).body(lastId);
    }

    @DeleteMapping("/delete")
    public ResponseEntity<Boolean> deleteSighting(int id){
        boolean success = sightingService.deleteRecipeById(id);
        if (success) {
            // Delete request succeeded.
            return ResponseEntity.status(HttpStatus.OK).body(true) ;
        }
        // Delete request failed.
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(false);
    }
}

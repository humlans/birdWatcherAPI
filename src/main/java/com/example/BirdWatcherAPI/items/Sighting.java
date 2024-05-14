package com.example.BirdWatcherAPI.items;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "sightings")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Sighting {
    @Id
    private int id;
    @Column
    private String title;
    @Column(columnDefinition = "DATETIME")
    private String dateTime;


    //Join with User
    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.DETACH)
    @JoinColumn(name = "username", nullable = false)
    @JsonIgnoreProperties(value = {"sightings"})
    private User user;

    // Join with BirdSpecies
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "bird_id", nullable = false)
    @JsonIgnoreProperties(value = {"sightings"})
    private BirdSpecies birdSpecies;

    @Column(columnDefinition = "TEXT")
    private String comment;
/*
    // Join with Notification
    @OneToOne(mappedBy = "sightingAdded")
    @JsonIgnoreProperties(value = {"sightingAdded"})
    private Notification notification;
*/

}

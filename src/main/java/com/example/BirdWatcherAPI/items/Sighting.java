package com.example.BirdWatcherAPI.items;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

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
    @Column(columnDefinition = "DATE")
    private String date;

    //Join with User
    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.DETACH)
    @JoinColumn(name = "username", nullable = false)
    @JsonIgnoreProperties(value = {"sightings"})
    private User user;

    // Join with BirdSpecies
    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.DETACH)
    @JoinColumn(name = "bird_id", nullable = false)
    @JsonIgnoreProperties(value = {"sightings"})
    private BirdSpecies birdSpecies;

    @Column(columnDefinition = "TEXT")
    private String comment;


    //Join with notifications
    @JsonIgnore
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "sighting", cascade = CascadeType.ALL)
    private List<Notification> notifications;

}

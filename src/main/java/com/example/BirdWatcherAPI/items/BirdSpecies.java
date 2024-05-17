package com.example.BirdWatcherAPI.items;


import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Table(name = "bird_species")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(exclude = {"sightings", "notifications"})
public class BirdSpecies {
    @Id
    private int id;
    @Column(nullable = false, unique = true)
    private String scientificName;
    @Column
    private String englishName;
    @Column
    private String family;
    @Column(columnDefinition = "TEXT")
    private String habitat;
    @Column(columnDefinition = "TEXT")
    private String diet;
    @Column
    private String gradeOfEndangerment;
    @Column(columnDefinition = "TEXT")
    private String appearance;
    @Column
    private int expectedLifetime;

    //Join with Sighting
    @JsonIgnore
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "birdSpecies", cascade = CascadeType.ALL)
    @JsonIgnoreProperties("birdSpecies")
    private List<Sighting> sightings;


    //Join with NotificationSender
    @JsonIgnore
    @OneToOne(fetch = FetchType.LAZY, mappedBy = "birdSpecies", cascade = CascadeType.ALL)
    @JsonIgnoreProperties("birdSpecies")
    private NotificationSender notificationSender;

}

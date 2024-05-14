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
    /*
    @ManyToMany
    @JoinTable(
            name = "birdspecies_subscribers_jointable",
            joinColumns = @JoinColumn(name = "birdspecies_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "subscribers_username", referencedColumnName = "username"))
    @JsonIgnoreProperties("subscriptions")
    private List<User> subscribers;

    //Join with Notification
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "birdSpecies", cascade = CascadeType.ALL)
    @JsonIgnoreProperties(value = {"birdSpecies"})
    private List<Notification> notifications;
*/
    //Join with Sighting
    @JsonIgnore
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "birdSpecies", cascade = CascadeType.ALL)
    @JsonIgnoreProperties("birdSpecies")
    private List<Sighting> sightings;

    public BirdSpecies(int id, String scientificName, String englishName, String family, String habitat, String diet, String gradeOfEndangerment, String appearance, int expectedLifetime) {
        this.id = id;
        this.scientificName = scientificName;
        this.englishName = englishName;
        this.family = family;
        this.habitat = habitat;
        this.diet = diet;
        this.gradeOfEndangerment = gradeOfEndangerment;
        this.appearance = appearance;
        this.expectedLifetime = expectedLifetime;
    }
}

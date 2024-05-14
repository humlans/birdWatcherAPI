package com.example.BirdWatcherAPI.items;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Table(name = "notifications")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(exclude = {"birdSpecies"})
public class Notification {
    @Id
    private int id;
    /*
    @ManyToMany
    @JoinTable(
            name = "notifications_users_jointable",
            joinColumns = @JoinColumn(name = "notification_id"),
            inverseJoinColumns = @JoinColumn(name = "subscribers_username"))
    @JsonIgnoreProperties("notifications")
    private List<User> subscribers;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "birdspecies_id", referencedColumnName = "id", nullable = false)
    @JsonIgnoreProperties(value = {"notifications"})
    private BirdSpecies birdSpecies;

    @OneToOne
    @JoinColumn(name = "sighting_id", referencedColumnName = "id")
    @JsonIgnoreProperties("notification")
    private Sighting sightingAdded;
 */
}

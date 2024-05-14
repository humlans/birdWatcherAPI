package com.example.BirdWatcherAPI.items;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "users")
@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(exclude = {"sightings", "subscriptions", "notifications"})
public class User {
    @Id
    private String username;
    @Column(unique = true)
    private String email;
    @Column
    private String password;
    @Column
    private boolean isAdmin;

    //Join with Sighting
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "user", cascade = CascadeType.ALL)
    @JsonIgnoreProperties("user")
    private List<Sighting> sightings;
/*
    //Join with BirdSpecies
    @ManyToMany(fetch = FetchType.LAZY, mappedBy = "subscribers", cascade = CascadeType.ALL)
    @JsonIgnoreProperties("subscribers")
    private List<BirdSpecies> subscriptions;

    //Join with Notification
    @ManyToMany(fetch = FetchType.LAZY, mappedBy = "subscribers", cascade = CascadeType.ALL)
    @JsonIgnoreProperties("subscribers")
    private List<Notification> notifications;
*/

}

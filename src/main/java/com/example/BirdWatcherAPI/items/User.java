package com.example.BirdWatcherAPI.items;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "users")
@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(exclude = {"sightings", "notifications"})
public class User {
    @Id
    private String username;
    @Column(unique = true)
    private String email;
    @Column
    private String password;

    //Join with Sighting
    @JsonIgnore
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "user", cascade = CascadeType.ALL)
    private List<Sighting> sightings;


    // Join with notifications
    @JsonIgnore
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "subscriber", cascade = CascadeType.ALL)
    private List<Notification> notifications;

    //Join with notificationListener
    @JsonIgnore
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "subscriber", cascade = CascadeType.ALL)
    private List<NotificationListener> notificationListeners;

}

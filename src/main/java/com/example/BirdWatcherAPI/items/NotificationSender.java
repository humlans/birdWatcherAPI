package com.example.BirdWatcherAPI.items;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "notification_sender")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class NotificationSender {
    @Id
    int id;

    //Join with NotificationListener
    @OneToMany(fetch = FetchType.EAGER, mappedBy = "notificationSender", cascade = CascadeType.DETACH, orphanRemoval = true)
    @JsonIgnoreProperties("notificationSender")
    private List<NotificationListener> notificationListeners;

    //Join with BirdSpecies
    @OneToOne(fetch = FetchType.EAGER, cascade = CascadeType.DETACH)
    @JoinColumn(name = "birdspecies_id", nullable = false)
    private BirdSpecies birdSpecies;

}

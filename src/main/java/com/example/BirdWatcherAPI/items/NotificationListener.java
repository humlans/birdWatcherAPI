package com.example.BirdWatcherAPI.items;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "notification_listeners")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class NotificationListener {
    @Id
    private int id;

    // Join with user
    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.DETACH)
    @JoinColumn(name = "subscriber_username")
    private User subscriber;


    //Join with notificationSender
    //@JsonIgnore
    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.DETACH)
    @JoinColumn(name = "notification_sender_id")
    private NotificationSender notificationSender;

}

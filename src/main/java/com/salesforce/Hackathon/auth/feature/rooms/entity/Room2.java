package com.salesforce.Hackathon.auth.feature.rooms.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Entity
@Table(name = "roomes")
@Data
public class Room2 {
    @Id
    private String id;

    private String name;
    private int capacity;

    private Boolean isBooked;

    @ElementCollection
    @CollectionTable(name = "room_amenities", joinColumns = @JoinColumn(name = "room_id"))
    @Column(name = "amenity")
    private List<String> amenities1;
}



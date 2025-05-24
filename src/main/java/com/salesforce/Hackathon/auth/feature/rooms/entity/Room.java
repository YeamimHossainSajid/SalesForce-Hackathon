package com.salesforce.Hackathon.auth.feature.rooms.entity;

import com.salesforce.Hackathon.generic.model.BaseEntity;
import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Entity
@Table(name = "rooms")
@Data
public class Room extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private int capacity;

    @ElementCollection
    private List<String> amenities;

    // Getters and Setters or use Lombok @Data
}


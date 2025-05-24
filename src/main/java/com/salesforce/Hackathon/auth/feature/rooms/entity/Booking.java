package com.salesforce.Hackathon.auth.feature.rooms.entity;


import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;

@Entity
@Table(name = "bookings")
@Data
public class Booking {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String userId; // who booked (could be user email or id)
    private String resourceId; // roomId or equipmentId
    private String resourceType; // "ROOM" or "EQUIPMENT"
    private String startTime;
    private String endTime;
    private String status; // BOOKED, CANCELLED, COMPLETED

    // getters & setters
}


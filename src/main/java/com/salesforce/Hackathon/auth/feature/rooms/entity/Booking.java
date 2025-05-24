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

    private String userId;
    private String resourceId;
    private String resourceType;
    private String startTime;
    private String endTime;
    private String status;

}


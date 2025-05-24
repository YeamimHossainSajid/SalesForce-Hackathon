package com.salesforce.Hackathon.auth.feature.rooms.entity;


import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "equipment")
@Data
public class Equipment {
    @Id
    private String id;  // e.g. "E001"

    private String name;
    private String type;
    private String serialNumber;

    // getters & setters
}


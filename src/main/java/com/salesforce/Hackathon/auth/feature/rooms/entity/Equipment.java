package com.salesforce.Hackathon.auth.feature.rooms.entity;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name = "equipment")
@Data
public class Equipment {
    @Id
    private String id;

    private String name;
    private String type;

    @Column(name = "serial_number")
    private String serialNumber;
}



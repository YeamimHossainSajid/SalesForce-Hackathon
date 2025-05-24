package com.salesforce.Hackathon.auth.feature.rooms.service;

import com.salesforce.Hackathon.auth.feature.rooms.entity.Room2;
import com.salesforce.Hackathon.auth.feature.rooms.repo.RoomRepository;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class Room2Service {

    private final RoomRepository room2Repository;

    public Room2Service(RoomRepository room2Repository) {
        this.room2Repository = room2Repository;
    }

    public List<Room2> getAllRooms() {
        return room2Repository.findAll();
    }

    public Room2 getRoomById(String id) {
        return room2Repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Room not found with id: " + id));
    }
}


package com.salesforce.Hackathon.auth.feature.rooms.controller;

import com.salesforce.Hackathon.auth.feature.rooms.entity.Room2;
import com.salesforce.Hackathon.auth.feature.rooms.service.Room2Service;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/rooms")
public class Room2Controller {

    private final Room2Service room2Service;

    public Room2Controller(Room2Service room2Service) {
        this.room2Service = room2Service;
    }

    @GetMapping
    public List<Room2> getAllRooms() {
        return room2Service.getAllRooms();
    }

    @GetMapping("/{id}")
    public Room2 getRoomById(@PathVariable String id) {
        return room2Service.getRoomById(id);
    }
}




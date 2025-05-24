package com.salesforce.Hackathon.auth.feature.rooms.controller;


import com.salesforce.Hackathon.auth.feature.rooms.entity.Equipment;
import com.salesforce.Hackathon.auth.feature.rooms.service.EquipmentService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/equipment")
public class EquipmentController {

    private final EquipmentService equipmentService;

    public EquipmentController(EquipmentService equipmentService) {
        this.equipmentService = equipmentService;
    }

    @GetMapping
    public List<Equipment> getAllEquipment() {
        return equipmentService.getAllEquipment();
    }

    @GetMapping("/{id}")
    public Equipment getEquipmentById(@PathVariable String id) {
        return equipmentService.getEquipmentById(id);
    }
}


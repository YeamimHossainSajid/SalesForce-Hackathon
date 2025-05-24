package com.salesforce.Hackathon.auth.feature.rooms.service;

import com.salesforce.Hackathon.auth.feature.rooms.dto.ExternalApiResponseDto;
import com.salesforce.Hackathon.auth.feature.rooms.dto.request.EquipmentDto;
import com.salesforce.Hackathon.auth.feature.rooms.dto.request.RoomDto;
import com.salesforce.Hackathon.auth.feature.rooms.entity.Equipment;

import com.salesforce.Hackathon.auth.feature.rooms.entity.Room2;
import com.salesforce.Hackathon.auth.feature.rooms.repo.EquipmentRepository;
import com.salesforce.Hackathon.auth.feature.rooms.repo.RoomRepository;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

@Service
public class DataSyncService {

    private final EquipmentRepository equipmentRepository;
    private final RoomRepository roomRepository;
    private final ExternalApiService externalApiService;

    public DataSyncService(EquipmentRepository equipmentRepository, RoomRepository roomRepository, ExternalApiService externalApiService) {
        this.equipmentRepository = equipmentRepository;
        this.roomRepository = roomRepository;
        this.externalApiService = externalApiService;
    }

    @Transactional
    public void syncExternalData() {
        ExternalApiResponseDto externalData = externalApiService.fetchExternalData();

        // Sync equipment
        for (EquipmentDto dto : externalData.getEquipment()) {
            Equipment equipment = equipmentRepository.findById(dto.getId())
                    .orElse(new Equipment());

            equipment.setId(dto.getId());
            equipment.setName(dto.getName());
            equipment.setType(dto.getType());
            equipment.setSerialNumber(dto.getSerialNumber());

            equipmentRepository.save(equipment);
        }

        // Sync rooms
        for (RoomDto dto : externalData.getRooms()) {
            Room2 room = roomRepository.findById(dto.getId())
                    .orElse(new Room2());

            room.setId(dto.getId());
            room.setName(dto.getName());
            room.setCapacity(dto.getCapacity());
            room.setAmenities1(dto.getAmenities());

            roomRepository.save(room);
        }
    }
}


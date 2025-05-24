package com.salesforce.Hackathon.auth.feature.rooms.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.salesforce.Hackathon.auth.feature.rooms.dto.response.ApiResponse;
import com.salesforce.Hackathon.auth.feature.rooms.entity.Equipment;
import com.salesforce.Hackathon.auth.feature.rooms.entity.Room2;
import com.salesforce.Hackathon.auth.feature.rooms.repo.EquipmentRepository;
import com.salesforce.Hackathon.auth.feature.rooms.repo.RoomRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import jakarta.transaction.Transactional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class DataImportService {

    private final RoomRepository roomRepository;
    private final EquipmentRepository equipmentRepository;
    private final RestTemplate restTemplate = new RestTemplate();
    private final ObjectMapper objectMapper = new ObjectMapper();

    private static final String DATA_URL = "https://raw.githubusercontent.com/twentyTwo/sf-hackathon-bd-2025/refs/heads/main/data.json";

    @Transactional
    public void fetchAndSaveRoomsAndEquipment() throws Exception {

        String json = restTemplate.getForObject(DATA_URL, String.class);


        ApiResponse apiResponse = objectMapper.readValue(json, ApiResponse.class);

        var equipmentList = apiResponse.getEquipment().stream().map(dto -> {
            Equipment e = new Equipment();
            e.setId(dto.getId());
            e.setName(dto.getName());
            e.setType(dto.getType());
            e.setSerialNumber(dto.getSerial_number());
            return e;
        }).collect(Collectors.toList());
        equipmentRepository.saveAll(equipmentList);

        var roomList = apiResponse.getRooms().stream().map(dto -> {
            Room2 r = new Room2();
            r.setId(dto.getId());
            r.setName(dto.getName());
            r.setCapacity(dto.getCapacity());
            r.setAmenities1(dto.getAmenities());
            return r;
        }).collect(Collectors.toList());
        roomRepository.saveAll(roomList);
    }
}

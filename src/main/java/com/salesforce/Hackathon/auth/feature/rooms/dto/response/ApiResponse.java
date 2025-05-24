package com.salesforce.Hackathon.auth.feature.rooms.dto.response;

import com.salesforce.Hackathon.auth.feature.rooms.dto.request.EquipmentDto;
import com.salesforce.Hackathon.auth.feature.rooms.dto.request.RoomDto;
import lombok.Data;

import java.util.List;

@Data
public class ApiResponse {
    private String last_updated;
    private List<EquipmentDto> equipment;
    private List<RoomDto> rooms;
}
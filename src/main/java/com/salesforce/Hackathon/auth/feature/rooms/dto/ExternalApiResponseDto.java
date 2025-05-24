package com.salesforce.Hackathon.auth.feature.rooms.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.salesforce.Hackathon.auth.feature.rooms.dto.request.EquipmentDto;
import com.salesforce.Hackathon.auth.feature.rooms.dto.request.RoomDto;
import lombok.Data;

import java.util.List;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class ExternalApiResponseDto {

    @JsonProperty("last_updated")
    private String lastUpdated;

    private List<EquipmentDto> equipment;

    private List<RoomDto> rooms;
}


package com.salesforce.Hackathon.auth.feature.rooms.dto.request;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
@Data
public class RoomDto {
    private List<String> amenities;
    private int capacity;
    private String name;
    private String id;
}


package com.salesforce.Hackathon.auth.feature.rooms.dto.request;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

import java.util.List;
@Data
public class RoomDto {
    private String id;
    private String name;
    private int capacity;
    private List<String> amenities;
}


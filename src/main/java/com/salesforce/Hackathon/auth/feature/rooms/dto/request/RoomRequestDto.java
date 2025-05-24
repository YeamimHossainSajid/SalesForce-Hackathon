package com.salesforce.Hackathon.auth.feature.rooms.dto.request;

import com.salesforce.Hackathon.generic.payload.request.IDto;


import java.util.List;

public class RoomRequestDto implements IDto {

    private String name;
    private int capacity;
    private List<String> amenities;

    public RoomRequestDto() {
    }

    public RoomRequestDto(String name, int capacity, List<String> amenities) {
        this.name = name;
        this.capacity = capacity;
        this.amenities = amenities;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public List<String> getAmenities() {
        return amenities;
    }

    public void setAmenities(List<String> amenities) {
        this.amenities = amenities;
    }
}


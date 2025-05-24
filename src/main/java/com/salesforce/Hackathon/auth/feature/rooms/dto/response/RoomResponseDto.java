package com.salesforce.Hackathon.auth.feature.rooms.dto.response;

import com.salesforce.Hackathon.generic.payload.response.BaseResponseDto;

import java.util.List;

public class RoomResponseDto extends BaseResponseDto {

    private Long id;
    private String name;
    private int capacity;
    private List<String> amenities;

    public RoomResponseDto() {
    }

    public RoomResponseDto(Long id, String name, int capacity, List<String> amenities) {
        this.id = id;
        this.name = name;
        this.capacity = capacity;
        this.amenities = amenities;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

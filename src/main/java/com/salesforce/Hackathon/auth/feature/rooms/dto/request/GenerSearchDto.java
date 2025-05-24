package com.salesforce.Hackathon.auth.feature.rooms.dto.request;


import com.salesforce.Hackathon.generic.payload.request.SDto;

import java.util.List;

public class GenerSearchDto extends SDto {

    private String keyword;             // For searching by name or general text
    private Integer minCapacity;        // Minimum capacity filter
    private Integer maxCapacity;        // Maximum capacity filter
    private List<String> amenities;     // Filter by amenities (all or any)

    public GenerSearchDto() {
    }

    public GenerSearchDto(String keyword, Integer minCapacity, Integer maxCapacity, List<String> amenities) {
        this.keyword = keyword;
        this.minCapacity = minCapacity;
        this.maxCapacity = maxCapacity;
        this.amenities = amenities;
    }

    public String getKeyword() {
        return keyword;
    }

    public void setKeyword(String keyword) {
        this.keyword = keyword;
    }

    public Integer getMinCapacity() {
        return minCapacity;
    }

    public void setMinCapacity(Integer minCapacity) {
        this.minCapacity = minCapacity;
    }

    public Integer getMaxCapacity() {
        return maxCapacity;
    }

    public void setMaxCapacity(Integer maxCapacity) {
        this.maxCapacity = maxCapacity;
    }

    public List<String> getAmenities() {
        return amenities;
    }

    public void setAmenities(List<String> amenities) {
        this.amenities = amenities;
    }
}

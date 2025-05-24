package com.salesforce.Hackathon.auth.feature.rooms.dto.request;

import lombok.Data;


@Data
public class EquipmentDto {
    private String id;
    private String name;
    private String type;
    private String serial_number;
}

package com.salesforce.Hackathon.auth.feature.rooms.controller;

import com.salesforce.Hackathon.auth.feature.rooms.dto.request.GenerSearchDto;
import com.salesforce.Hackathon.auth.feature.rooms.dto.request.RoomRequestDto;
import com.salesforce.Hackathon.auth.feature.rooms.entity.Room;
import com.salesforce.Hackathon.generic.controller.AbstractController;
import com.salesforce.Hackathon.generic.service.IService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("room")
public class RoomController extends AbstractController<Room, RoomRequestDto, GenerSearchDto> {
    public RoomController(IService<Room, RoomRequestDto, GenerSearchDto> service) {
        super(service);
    }
}

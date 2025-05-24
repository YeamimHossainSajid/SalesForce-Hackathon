//package com.salesforce.Hackathon.auth.feature.rooms.controller;
//
//import com.salesforce.Hackathon.auth.feature.rooms.dto.request.GenerSearchDto;
//import com.salesforce.Hackathon.auth.feature.rooms.dto.request.RoomRequestDto;
//import com.salesforce.Hackathon.auth.feature.rooms.dto.response.RoomResponseDto;
//import com.salesforce.Hackathon.auth.feature.rooms.entity.Room;
//import com.salesforce.Hackathon.auth.feature.rooms.service.RoomService;
//import com.salesforce.Hackathon.generic.controller.AbstractController;
//import com.salesforce.Hackathon.generic.service.IService;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RestController;
//
//import com.salesforce.Hackathon.auth.feature.rooms.dto.request.GenerSearchDto;
//import com.salesforce.Hackathon.auth.feature.rooms.dto.request.RoomRequestDto;
//import com.salesforce.Hackathon.auth.feature.rooms.dto.response.RoomResponseDto;
//import com.salesforce.Hackathon.auth.feature.rooms.service.RoomService;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.*;
//
//import java.util.List;
//
//@RestController
//@RequestMapping("/api/rooms")
//public class RoomController {
//
//    private final RoomService roomService;
//
//    @Autowired
//    public RoomController(RoomService roomService) {
//        this.roomService = roomService;
//    }
//
//    // Create a new Room
//    @PostMapping
//    public ResponseEntity<RoomResponseDto> createRoom(@RequestBody RoomRequestDto roomRequestDto) {
//        RoomResponseDto createdRoom = roomService.create(roomRequestDto);
//        return ResponseEntity.ok(createdRoom);
//    }
//
//    // Get a Room by ID
//    @GetMapping("/{id}")
//    public ResponseEntity<RoomResponseDto> getRoomById(@PathVariable Long id) {
//        RoomResponseDto room = roomService.getById(id);
//        if (room == null) {
//            return ResponseEntity.notFound().build();
//        }
//        return ResponseEntity.ok(room);
//    }
//
//    // Update Room by ID
//    @PutMapping("/{id}")
//    public ResponseEntity<RoomResponseDto> updateRoom(@PathVariable Long id, @RequestBody RoomRequestDto roomRequestDto) {
//        RoomResponseDto updatedRoom = roomService.update(id, roomRequestDto);
//        if (updatedRoom == null) {
//            return ResponseEntity.notFound().build();
//        }
//        return ResponseEntity.ok(updatedRoom);
//    }
//
//    // Delete Room by ID
//    @DeleteMapping("/{id}")
//    public ResponseEntity<Void> deleteRoom(@PathVariable Long id) {
//        boolean deleted = roomService.delete(id);
//        if (!deleted) {
//            return ResponseEntity.notFound().build();
//        }
//        return ResponseEntity.noContent().build();
//    }
//
//    // Search Rooms with filters
//    @PostMapping("/search")
//    public ResponseEntity<List<RoomResponseDto>> searchRooms(@RequestBody GenericSearchDto searchDto) {
//        List<RoomResponseDto> rooms = roomService.search(searchDto);
//        return ResponseEntity.ok(rooms);
//    }
//}



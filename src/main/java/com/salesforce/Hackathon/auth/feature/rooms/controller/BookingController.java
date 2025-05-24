package com.salesforce.Hackathon.auth.feature.rooms.controller;

import com.salesforce.Hackathon.auth.feature.rooms.entity.Booking;
import com.salesforce.Hackathon.auth.feature.rooms.entity.Equipment;
import com.salesforce.Hackathon.auth.feature.rooms.entity.Room2;
import com.salesforce.Hackathon.auth.feature.rooms.service.BookingService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("/api/bookings")
public class BookingController {

    private final BookingService bookingService;

    public BookingController(BookingService bookingService) {
        this.bookingService = bookingService;
    }

    // Get all rooms
    @GetMapping("/rooms")
    public ResponseEntity<List<Room2>> getAllRooms() {
        return ResponseEntity.ok(bookingService.getAllRooms());
    }

    // Get all equipment
    @GetMapping("/equipment")
    public ResponseEntity<List<Equipment>> getAllEquipment() {
        return ResponseEntity.ok(bookingService.getAllEquipment());
    }

    // Book a resource (room or equipment)
    @PostMapping("/book")
    public ResponseEntity<?> bookResource(@RequestParam Long userId,
                                          @RequestParam String resourceId,
                                          @RequestParam String resourceType,
                                          @RequestParam String start,
                                          @RequestParam String end) {
        try {

            Booking booking = bookingService.bookResource(userId, resourceId, resourceType, start, end);
            return ResponseEntity.ok(booking);
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    // Cancel a booking
    @PostMapping("/cancel")
    public ResponseEntity<?> cancelBooking(@RequestParam Long bookingId,
                                           @RequestParam Long userId) {
        try {
            bookingService.cancelBooking(bookingId, userId);
            return ResponseEntity.ok("Booking cancelled successfully");
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }


    @GetMapping("/user/{userId}")
    public ResponseEntity<List<Booking>> getUserBookings(@PathVariable String userId) {
        return ResponseEntity.ok(bookingService.getUserBookings(userId));
    }

    @GetMapping("/rooms/booked")
    public ResponseEntity<List<Room2>> getBookedRooms() {
        return ResponseEntity.ok(bookingService.getBookedRooms());
    }

    // Get all available (non-booked) rooms
    @GetMapping("/rooms/available")
    public ResponseEntity<List<Room2>> getAvailableRooms() {
        return ResponseEntity.ok(bookingService.getAvailableRooms());
    }

    // Get all booked equipment
    @GetMapping("/equipment/booked")
    public ResponseEntity<List<Equipment>> getBookedEquipment() {
        return ResponseEntity.ok(bookingService.getBookedEquipment());
    }

    // Get all available (non-booked) equipment
    @GetMapping("/equipment/available")
    public ResponseEntity<List<Equipment>> getAvailableEquipment() {
        return ResponseEntity.ok(bookingService.getAvailableEquipment());
    }
    @GetMapping("/bookingtime")
    public ResponseEntity<List<Booking>> getAllBookings() {
        return ResponseEntity.ok(bookingService.getBookings());
    }
}

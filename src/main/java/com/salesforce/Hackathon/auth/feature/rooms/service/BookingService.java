package com.salesforce.Hackathon.auth.feature.rooms.service;

import com.salesforce.Hackathon.auth.feature.rooms.entity.Booking;
import com.salesforce.Hackathon.auth.feature.rooms.entity.Equipment;
import com.salesforce.Hackathon.auth.feature.rooms.entity.Room2;
import com.salesforce.Hackathon.auth.feature.rooms.repo.BookingRepository;
import com.salesforce.Hackathon.auth.feature.rooms.repo.EquipmentRepository;
import com.salesforce.Hackathon.auth.feature.rooms.repo.RoomRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class BookingService {

    private final BookingRepository bookingRepository;
    private final RoomRepository roomRepository;
    private final EquipmentRepository equipmentRepository;

    public BookingService(BookingRepository bookingRepository, RoomRepository roomRepository,
                          EquipmentRepository equipmentRepository) {
        this.bookingRepository = bookingRepository;
        this.roomRepository = roomRepository;
        this.equipmentRepository = equipmentRepository;
    }


    public List<Room2> getAllRooms() {
        return roomRepository.findAll();
    }


    public List<Equipment> getAllEquipment() {
        return equipmentRepository.findAll();
    }


    public boolean isResourceAvailable(String resourceId, String start, String end) {
        List<Booking> conflicting = bookingRepository.findByResourceIdAndStatusAndStartTimeLessThanAndEndTimeGreaterThan(
                resourceId, "BOOKED", end, start);
        return conflicting.isEmpty();
    }


    @Transactional
    public Booking bookResource(String userId, String resourceId, String resourceType,
                                String start, String end) throws Exception {
        if (!resourceType.equalsIgnoreCase("ROOM") && !resourceType.equalsIgnoreCase("EQUIPMENT")) {
            throw new Exception("Invalid resource type");
        }


        if (resourceType.equalsIgnoreCase("ROOM") && !roomRepository.existsById(resourceId)) {
            throw new Exception("Room not found");
        }
        if (resourceType.equalsIgnoreCase("EQUIPMENT") && !equipmentRepository.existsById(resourceId)) {
            throw new Exception("Equipment not found");
        }


        if (!isResourceAvailable(resourceId, start, end)) {
            throw new Exception("Resource not available at selected time");
        }

        Booking booking = new Booking();
        booking.setUserId(userId);
        booking.setResourceId(resourceId);
        booking.setResourceType(resourceType.toUpperCase());
        booking.setStartTime(start);
        booking.setEndTime(end);
        booking.setStatus("BOOKED");


        return bookingRepository.save(booking);
    }


    @Transactional
    public void cancelBooking(Long bookingId, String userId) throws Exception {
        Optional<Booking> opt = bookingRepository.findById(bookingId);
        if (opt.isEmpty()) {
            throw new Exception("Booking not found");
        }
        Booking booking = opt.get();
        if (!booking.getUserId().equals(userId)) {
            throw new Exception("Unauthorized to cancel this booking");
        }
        booking.setStatus("CANCELLED");
        bookingRepository.save(booking);
    }


    public List<Booking> getUserBookings(String userId) {
        return bookingRepository.findByUserId(userId);
    }
}


package com.salesforce.Hackathon.auth.feature.rooms.service;

import com.salesforce.Hackathon.auth.feature.rooms.entity.Booking;
import com.salesforce.Hackathon.auth.feature.rooms.entity.Equipment;
import com.salesforce.Hackathon.auth.feature.rooms.entity.Room2;
import com.salesforce.Hackathon.auth.feature.rooms.repo.BookingRepository;
import com.salesforce.Hackathon.auth.feature.rooms.repo.EquipmentRepository;
import com.salesforce.Hackathon.auth.feature.rooms.repo.RoomRepository;
import com.salesforce.Hackathon.auth.model.User;
import com.salesforce.Hackathon.auth.repository.UserRepo;
import com.salesforce.Hackathon.config.mail.EmailService;
import org.springframework.beans.factory.annotation.Autowired;
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
    private final EmailService emailService;
    @Autowired
    private UserRepo userRepo;// Inject email service

    public BookingService(BookingRepository bookingRepository, RoomRepository roomRepository,
                          EquipmentRepository equipmentRepository, EmailService emailService) {
        this.bookingRepository = bookingRepository;
        this.roomRepository = roomRepository;
        this.equipmentRepository = equipmentRepository;
        this.emailService = emailService;
    }

    // ... your existing methods ...

    @Transactional
    public Booking bookResource(Long userId, String resourceId, String resourceType,
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


        Booking booking = new Booking();
        booking.setUserId(String.valueOf(userId));
        booking.setResourceId(resourceId);
        booking.setResourceType(resourceType.toUpperCase());
        booking.setStartTime(start);
        booking.setEndTime(end);
        booking.setStatus("BOOKED");

        if (resourceType.equalsIgnoreCase("ROOM")) {
            roomRepository.findById(resourceId).ifPresent(room -> {
                room.setIsBooked(true);
                roomRepository.save(room);
            });
        } else if (resourceType.equalsIgnoreCase("EQUIPMENT")) {
            equipmentRepository.findById(resourceId).ifPresent(equipment -> {
                equipment.setIsBooked(true);
                equipmentRepository.save(equipment);
            });
        }

        Booking savedBooking = bookingRepository.save(booking);

        // Send booking notification to all users for both ROOM and EQUIPMENT
        List<User> allUsers = userRepo.findAll();
        for (User user : allUsers) {
            emailService.sendRoomStatusEmail(user.getEmail(), resourceId, "BOOKED",start,end);
        }



        return savedBooking;
    }

    @Transactional
    public void cancelBooking(Long bookingId, Long userId) throws Exception {
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


        String resourceType = booking.getResourceType();
        String resourceId = booking.getResourceId();

        if ("ROOM".equalsIgnoreCase(resourceType)) {
            roomRepository.findById(resourceId).ifPresent(room -> {
                room.setIsBooked(false);
                roomRepository.save(room);
            });

            List<User> allUsers = userRepo.findAll();
            for (User user : allUsers) {
                emailService.sendRoomStatusEmail(user.getEmail(), resourceId, "CANCELLED",null,null);
            }



        } else if ("EQUIPMENT".equalsIgnoreCase(resourceType)) {
            equipmentRepository.findById(resourceId).ifPresent(equipment -> {
                equipment.setIsBooked(false);
                equipmentRepository.save(equipment);
            });
        }
    }

    private String getUserEmailById(Long userId) {
        return userRepo.findById(userId)
                .map(User::getEmail)
                .orElseThrow(() -> new RuntimeException("User not found with id: " + userId));
    }
    public List<Room2> getAllRooms() {
        return roomRepository.findAll();
    }


    public List<Equipment> getAllEquipment() {
        return equipmentRepository.findAll();
    }
    public List<Booking> getUserBookings(String userId) {
        return bookingRepository.findByUserId(userId);
    }

    public List<Room2> getBookedRooms() {
        return roomRepository.findByIsBookedTrue();
    }

    public List<Room2> getAvailableRooms() {
        return roomRepository.findByIsBookedFalse();
    }

    public List<Equipment> getBookedEquipment() {
        return equipmentRepository.findByIsBookedTrue();
    }

    public List<Equipment> getAvailableEquipment() {
        return equipmentRepository.findByIsBookedFalse();
    }

    public List<Booking> getBookings() {
        return bookingRepository.findAll();
    }
}

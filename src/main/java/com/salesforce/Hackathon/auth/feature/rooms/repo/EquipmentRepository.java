package com.salesforce.Hackathon.auth.feature.rooms.repo;


import com.salesforce.Hackathon.auth.feature.rooms.entity.Equipment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EquipmentRepository extends JpaRepository<Equipment, String> {
    List<Equipment> findByIsBookedTrue();

    // Find all equipment where isBooked = false (available/non-booked)
    List<Equipment> findByIsBookedFalse();
}

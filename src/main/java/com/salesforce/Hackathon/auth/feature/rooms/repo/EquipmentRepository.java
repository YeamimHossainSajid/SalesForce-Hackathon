package com.salesforce.Hackathon.auth.feature.rooms.repo;


import com.salesforce.Hackathon.auth.feature.rooms.entity.Equipment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EquipmentRepository extends JpaRepository<Equipment, String> {}

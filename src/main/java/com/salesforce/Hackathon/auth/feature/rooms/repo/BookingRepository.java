package com.salesforce.Hackathon.auth.feature.rooms.repo;

import com.salesforce.Hackathon.auth.feature.rooms.entity.Booking;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface BookingRepository extends JpaRepository<Booking, Long> {
    List<Booking> findByResourceIdAndStatusAndStartTimeLessThanAndEndTimeGreaterThan(
            String resourceId, String status, String endTime, String startTime);

    List<Booking> findByUserId(String userId);
}


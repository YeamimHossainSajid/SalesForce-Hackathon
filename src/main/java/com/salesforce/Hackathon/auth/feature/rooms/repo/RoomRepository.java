package com.salesforce.Hackathon.auth.feature.rooms.repo;


import com.salesforce.Hackathon.auth.feature.rooms.entity.Room2;
import com.salesforce.Hackathon.generic.repository.AbstractRepository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RoomRepository extends JpaRepository<Room2, String> {
    @Query("SELECT CASE WHEN COUNT(r) > 0 THEN true ELSE false END FROM Room2 r WHERE r.id = :id")
    boolean existsRoomById(@Param("id") String id);

    List<Room2> findByIsBookedTrue();

    List<Room2> findByIsBookedFalse();


}

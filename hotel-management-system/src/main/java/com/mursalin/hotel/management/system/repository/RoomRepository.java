package com.mursalin.hotel.management.system.repository;

import com.mursalin.hotel.management.system.model.Room;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoomRepository extends JpaRepository<Room, Long> {
}

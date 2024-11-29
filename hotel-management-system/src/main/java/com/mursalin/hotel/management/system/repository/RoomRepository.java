package com.mursalin.hotel.management.system.repository;

import com.mursalin.hotel.management.system.model.Room;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface RoomRepository extends JpaRepository<Room, Long> {

    @Query("select distinct r.roomType from Room r")
    List<String> findDistinctRoomTypes();

    @Query("select r from Room r where r.roomType like %:roomType% and r.id not in " +
            "(select b.room.id from Booking b where b.checkInDate <= :checkOutDate and b.checkOutDate >= :checkInDate)")
    List<Room> findAvailableRoomsByDatesAndTypes(LocalDate checkInDate, LocalDate checkOutDate, String roomType);

    @Query("SELECT r FROM Room r WHERE r.id NOT IN (SELECT b.room.id FROM Booking b)")
    List<Room> getAllAvailableRooms();
}

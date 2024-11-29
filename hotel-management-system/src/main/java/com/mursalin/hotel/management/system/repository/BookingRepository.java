package com.mursalin.hotel.management.system.repository;

import com.mursalin.hotel.management.system.model.Booking;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BookingRepository extends JpaRepository<Booking, Long> {

    List<Booking> findByRoomId(long roomId);

    List<Booking> findByUserId(long userId);

    List<Booking> findByBookingConfirmationCode(String bookingConfirmationCode);
}

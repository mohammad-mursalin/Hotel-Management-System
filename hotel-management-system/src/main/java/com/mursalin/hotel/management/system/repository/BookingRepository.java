package com.mursalin.hotel.management.system.repository;

import com.mursalin.hotel.management.system.model.Booking;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface BookingRepository extends JpaRepository<Booking, Long> {

    List<Booking> findByRoomId(long roomId);

    List<Booking> findByUserId(long userId);

    List<Booking> findByConfirmationCode(String confirmationCode);
}

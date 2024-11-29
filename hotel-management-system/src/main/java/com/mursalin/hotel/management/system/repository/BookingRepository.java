package com.mursalin.hotel.management.system.repository;

import com.mursalin.hotel.management.system.model.Booking;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookingRepository extends JpaRepository<Booking, Long> {
}

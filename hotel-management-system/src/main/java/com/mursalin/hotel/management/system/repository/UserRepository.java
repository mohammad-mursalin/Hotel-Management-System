package com.mursalin.hotel.management.system.repository;

import com.mursalin.hotel.management.system.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}

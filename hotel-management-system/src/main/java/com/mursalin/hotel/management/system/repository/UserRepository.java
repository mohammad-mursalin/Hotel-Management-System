package com.mursalin.hotel.management.system.repository;

import com.mursalin.hotel.management.system.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {

    boolean existByEmail(String email);

    Optional<User> findByEmail(String email);
}

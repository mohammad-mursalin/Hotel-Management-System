package com.mursalin.hotel.management.system.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @NotBlank(message = "name is required")
    private String name;

    @NotBlank(message = "email is required")
    @Column(unique = true)
    private String email;

    @NotBlank(message = "phoneNumber is required")
    private String phoneNumber;
    private String password;
    private String role;

    private List<Booking> bookings = new ArrayList<>();
}

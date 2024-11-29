package com.mursalin.hotel.management.system.DTO;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.mursalin.hotel.management.system.model.Booking;
import jakarta.persistence.Column;
import jakarta.persistence.OneToMany;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class UserDTO {

    private long id;
    private String name;
    private String email;
    private String phoneNumber;
    private String role;
    private List<BookingDTO> bookings = new ArrayList<>();
}

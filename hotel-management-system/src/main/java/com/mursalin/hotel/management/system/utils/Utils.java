package com.mursalin.hotel.management.system.utils;

import com.mursalin.hotel.management.system.DTO.BookingDTO;
import com.mursalin.hotel.management.system.DTO.RoomDTO;
import com.mursalin.hotel.management.system.DTO.UserDTO;
import com.mursalin.hotel.management.system.model.Booking;
import com.mursalin.hotel.management.system.model.Room;
import com.mursalin.hotel.management.system.model.User;

import java.security.SecureRandom;
import java.util.List;
import java.util.stream.Collectors;

public class Utils {

    private static final String ALPHANUMERIC_STRING = "ABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
    private static final SecureRandom secureRandom = new SecureRandom();


    public static String generateRandomConfirmationCode(int length) {
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < length; i++) {
            int randomIndex = secureRandom.nextInt(ALPHANUMERIC_STRING.length());
            char randomChar = ALPHANUMERIC_STRING.charAt(randomIndex);
            stringBuilder.append(randomChar);
        }
        return stringBuilder.toString();
    }


    public static UserDTO mapUserEntityToUserDTO(User user) {
        return UserDTO.builder()
                .id(user.getId())
                .name(user.getName())
                .email(user.getEmail())
                .phoneNumber(user.getPhoneNumber())
                .role(user.getRole())
                .build();
    }

    public static RoomDTO mapRoomEntityToRoomDTO(Room room) {
        return RoomDTO.builder()
                .id(room.getId())
                .roomType(room.getRoomType())
                .roomPrice(room.getRoomPrice())
                .roomPhotoUrl(room.getRoomPhotoUrl())
                .roomDescription(room.getRoomDescription())
                .build();
    }

    public static BookingDTO mapBookingEntityToBookingDTO(Booking booking) {
        return BookingDTO.builder()
                .id(booking.getId())
                .checkInDate(booking.getCheckInDate())
                .checkOutDate(booking.getCheckOutDate())
                .numOfAdults(booking.getNumOfAdults())
                .numOfChildren(booking.getNumOfChildren())
                .totalNumOfGuest(booking.getTotalNumOfGuest())
                .bookingConfirmationCode(booking.getBookingConfirmationCode())
                .build();
    }

    public static RoomDTO mapRoomEntityToRoomDTOPlusBookings(Room room) {
        RoomDTO roomDTO = mapRoomEntityToRoomDTO(room);

        if (room.getBookings() != null) {
            roomDTO.setBookings(room.getBookings().stream().map(Utils::mapBookingEntityToBookingDTO).collect(Collectors.toList()));
        }
        return roomDTO;
    }

    public static BookingDTO mapBookingEntityToBookingDTOPlusBookedRooms(Booking booking, boolean mapUser) {

        BookingDTO bookingDTO = mapBookingEntityToBookingDTO(booking);

        if (mapUser) {
            bookingDTO.setUser(Utils.mapUserEntityToUserDTO(booking.getUser()));
        }
        if (booking.getRoom() != null) {
            RoomDTO roomDTO = RoomDTO.builder()
                    .id(booking.getRoom().getId())
                    .roomType(booking.getRoom().getRoomType())
                    .roomPrice(booking.getRoom().getRoomPrice())
                    .roomPhotoUrl(booking.getRoom().getRoomPhotoUrl())
                    .roomDescription(booking.getRoom().getRoomDescription())
                    .build();
            bookingDTO.setRoom(roomDTO);
        }
        return bookingDTO;
    }

    public static UserDTO mapUserEntityToUserDTOPlusUserBookingsAndRoom(User user) {
        UserDTO userDTO = mapUserEntityToUserDTO(user);

        if (!user.getBookings().isEmpty()) {
            userDTO.setBookings(user.getBookings().stream().map(booking -> mapBookingEntityToBookingDTOPlusBookedRooms(booking, false)).collect(Collectors.toList()));
        }
        return userDTO;
    }


    public static List<UserDTO> mapUserListEntityToUserListDTO(List<User> userList) {
        return userList.stream().map(Utils::mapUserEntityToUserDTO).collect(Collectors.toList());
    }

    public static List<RoomDTO> mapRoomListEntityToRoomListDTO(List<Room> roomList) {
        return roomList.stream().map(Utils::mapRoomEntityToRoomDTO).collect(Collectors.toList());
    }

    public static List<BookingDTO> mapBookingListEntityToBookingListDTO(List<Booking> bookingList) {
        return bookingList.stream().map(Utils::mapBookingEntityToBookingDTO).collect(Collectors.toList());
    }


}



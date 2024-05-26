package com.rajat.BookMyShow.dto;

import com.rajat.BookMyShow.Models.Booking;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class CreateUserDTO {
    private String name;
    private String email;
    private List<Booking> bookings;
}

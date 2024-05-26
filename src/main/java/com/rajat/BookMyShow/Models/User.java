package com.rajat.BookMyShow.Models;

import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Setter
@Getter
@Entity
public class User extends BaseModel{
    private String name;
    private String email;
    private List<Booking> bookings;
    public User(String name, String email){
        this.name = name;
        this.email = email;
    }
    public void AddBooking(Booking booking){
        bookings.add(booking);
    }
}

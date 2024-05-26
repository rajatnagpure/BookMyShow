package com.rajat.BookMyShow.Models;

import com.rajat.BookMyShow.Enums.SeatType;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@AllArgsConstructor
public class Seat extends BaseModel{
    private int number;
    private int row;
    private int col;
    @Enumerated(EnumType.STRING)
    private SeatType seatType;
}

package com.rajat.BookMyShow.dto;

import com.rajat.BookMyShow.Enums.SeatType;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class AddSeatDTO {
    private long screenId;
    private int row;
    private int col;
    private SeatType seatType;
}

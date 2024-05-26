package com.rajat.BookMyShow.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class CreateBookingDTO {
    private long userId;
    private long showId;
    private List<Long> showSeatIds;
}

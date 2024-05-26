package com.rajat.BookMyShow.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.extern.java.Log;

import java.util.List;

@Getter
@Setter
public class BookTicketRequestDTO {
    public long userId;
    public long screenId;
    public List<Long> showSeatIds;
}

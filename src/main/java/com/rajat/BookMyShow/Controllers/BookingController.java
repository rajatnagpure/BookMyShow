package com.rajat.BookMyShow.Controllers;

import com.rajat.BookMyShow.Services.BookingService;
import com.rajat.BookMyShow.dto.CreateBookingDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BookingController {
    @Autowired
    private BookingService bookingService;

    @PostMapping("/create")
    public ResponseEntity createBooking(@RequestBody CreateBookingDTO createBookingDTO) throws Exception{
        return ResponseEntity.ok(bookingService.CreateBooking(createBookingDTO.getUserId(), createBookingDTO.getShowId(), createBookingDTO.getShowSeatIds()));
    }
}

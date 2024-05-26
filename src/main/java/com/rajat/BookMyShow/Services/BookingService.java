package com.rajat.BookMyShow.Services;

import com.rajat.BookMyShow.Enums.SeatStatus;
import com.rajat.BookMyShow.Models.*;
import com.rajat.BookMyShow.Repositories.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

@Service
public class BookingService {
    @Autowired
    private ShowSeatRepository showSeatRepository;
    @Autowired
    private ShowRepository showRepository;
    @Autowired
    private BookingRepository bookingRepository;
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private PaymentRepository paymentRepository;

    private Payment makePayment(float amount){
        Scanner scanner = new Scanner(System.in);
        Payment payment = new Payment("Paytm", scanner.nextLine(), true, amount);
        paymentRepository.save(payment);
        return payment;
    }
    @Transactional(isolation = Isolation.SERIALIZABLE)
    public long CreateBooking(long userId, long showId, List<Long> showSeatIds) throws Exception{
        Show show;
        User user;
        try{
            show = showRepository.findById(showId).get();
        }catch (Exception ex){
            throw ex;
        }
        try{
            user = userRepository.findById(userId).get();
        }catch (Exception ex){
            throw ex;
        }

        List<ShowSeat> showSeats = new ArrayList<>();
        float amount = 0.0f;
        //Validate if seats are not already booked
        for (long id : showSeatIds) {
            ShowSeat showSeat = showSeatRepository.findById(id).get();
            if (showSeat.getStatus() == SeatStatus.BOOKED) throw new Exception("Seat already booked");
            showSeats.add(showSeat);
            amount += showSeat.getPrice();
        }

        Payment payment = makePayment(amount);
        if(!payment.isSuccessful()) throw new Exception("Payment unsuccessful");

        Booking booking = new Booking(show, showSeats);
        booking.makePayment(payment);
        bookingRepository.save(booking);
        userRepository.findById(userId).get().AddBooking(booking);
        return booking.getId();
    }
}

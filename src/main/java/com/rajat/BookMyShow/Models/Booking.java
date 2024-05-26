package com.rajat.BookMyShow.Models;

import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Setter
@Getter
@Entity
@AllArgsConstructor
public class Booking extends BaseModel{
    @OneToOne
    private Show show;
    @OneToMany
    private List<ShowSeat> showSeats;
    private boolean isCancelled;
    @OneToMany
    private List<Payment> payments;
    public Booking(Show show, List<ShowSeat> showSeats){
        this.show = show;
        this.showSeats = showSeats;
    }
    public void makePayment(Payment payment){
        payments.add(payment);
        super.Update();
    }
    public void cancelBooking(){
        isCancelled = true;
        super.Update();
    }
}

package com.rajat.BookMyShow.Models;

import com.rajat.BookMyShow.Enums.SeatStatus;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.OneToOne;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@AllArgsConstructor
public class ShowSeat extends BaseModel{
    @OneToOne
    private Seat seat;
    @Enumerated(EnumType.STRING)
    private SeatStatus status;
    private float price;
    public ShowSeat(Seat seat, float price){
        this.seat = seat;
        this.price = price;
    }
}

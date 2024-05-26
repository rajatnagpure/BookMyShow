package com.rajat.BookMyShow.Models;

import com.rajat.BookMyShow.Enums.Feature;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@Entity
public class Screen extends BaseModel{
    private String name;
    @OneToMany
    private List<Seat> seats;
    @ElementCollection
    @Enumerated(EnumType.STRING)
    private List<Feature> features;
    public Screen(String name, List<Feature> features){
        this.name = name;
        this.features = features;
    }
    public void AddSeat(Seat seat){
        seats.add(seat);
        super.Update();
    }
}

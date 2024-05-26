package com.rajat.BookMyShow.Models;

import com.rajat.BookMyShow.Enums.Feature;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;
import java.util.List;

@Getter
@Setter
@Entity
@AllArgsConstructor
public class Show extends BaseModel{
    @OneToOne
    private Movie movie;
    @ElementCollection
    @Enumerated(EnumType.STRING)
    private List<Feature> features;
    @OneToMany
    private List<ShowSeat> showSeats;
    @OneToOne
    private Screen screen;
    private Date startTime;
    private Date endTime;
}

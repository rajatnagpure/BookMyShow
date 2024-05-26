package com.rajat.BookMyShow.Services;

import com.rajat.BookMyShow.Enums.Feature;
import com.rajat.BookMyShow.Enums.SeatType;
import com.rajat.BookMyShow.Models.*;
import com.rajat.BookMyShow.Repositories.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.util.*;

@Service
public class ShowService {
    @Autowired
    private ShowRepository showRepository;
    @Autowired
    private ShowSeatRepository showSeatRepository;
    @Autowired
    private ScreenRepository screenRepository;
    @Autowired
    private MovieRepository movieRepository;

    private float getSeatPrice(Seat seat, Movie movie, Date date){
        // custome price logic
        if(seat.getSeatType() == SeatType.RECLINER) return 5.0f;
        else return 4.0f;
    }

    public long CreateShow(long screenId, Date date, long movieId, List<Feature> features) throws Exception{
        Screen screen = screenRepository.findById(screenId).get();
        Movie movie = movieRepository.findById(movieId).get();
        Optional<Show> optionalShow = showRepository.findAll().stream().filter(show -> show.getStartTime() == date
                && show.getScreen() == screen
                && show.getMovie() == movie).findFirst();
        if(optionalShow.isPresent()) throw new Exception("Show already exists for this Screen on mentioned time");
        List<ShowSeat> showSeats = new ArrayList<>();
        screen.getSeats().forEach(seat -> {
            ShowSeat showSeat = new ShowSeat(seat,getSeatPrice(seat, movie, date));
            showSeatRepository.save(showSeat);
            showSeats.add(showSeat);
        });
        Instant startTime = date.toInstant();
        Date endTime = Date.from(startTime.plus(movie.getDuration()));
        Show show = new Show(movie,
                features,
                showSeats,
                screen,
                date,
                endTime);
        showRepository.save(show);
        return show.getId();
    }
}

package com.rajat.BookMyShow.Services;

import com.rajat.BookMyShow.Enums.Feature;
import com.rajat.BookMyShow.Enums.SeatType;
import com.rajat.BookMyShow.Models.Screen;
import com.rajat.BookMyShow.Models.Seat;
import com.rajat.BookMyShow.Models.Theater;
import com.rajat.BookMyShow.Repositories.RegionRepository;
import com.rajat.BookMyShow.Repositories.ScreenRepository;
import com.rajat.BookMyShow.Repositories.SeatRepository;
import com.rajat.BookMyShow.Repositories.TheaterRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TheaterService {
    @Autowired
    private RegionRepository regionRepository;
    @Autowired
    private TheaterRepository theaterRepository;
    @Autowired
    private ScreenRepository screenRepository;
    @Autowired
    private SeatRepository seatRepository;
    public long AddTheater(String name, long regionId){
        Theater theater = new Theater(name);
        theaterRepository.save(theater);
        regionRepository.findById(regionId).get().AddTheater(theater);
        return theater.getId();
    }
    public long AddScreen(String name, List<Feature> features, long theaterId){
        Screen screen = new Screen(name, features);
        screenRepository.save(screen);
        theaterRepository.findById(theaterId).get().AddScreen(screen);
        AddSeats(screen.getId());
        return screen.getId();
    }
    private void AddSeats(long screenId){
        Screen screen = screenRepository.findById(screenId).get();
        for(int i=0;i<10;i++){
            Seat seat = new Seat(i+1,0, i, SeatType.NON_RECLINER);
            seatRepository.save(seat);
            screen.AddSeat(seat);
        }
        for(int i=0;i<10;i++){
            Seat seat = new Seat(i+1,0, i, SeatType.RECLINER);
            seatRepository.save(seat);
            screen.AddSeat(seat);
        }
    }
    public void AddSeat(long screenId, int row, int col, SeatType seatType) throws Exception{
        Optional<Seat> seatOptional = seatRepository.findAll().stream().filter(x -> (x.getRow() == row && x.getCol() == col)).findFirst();
        if(seatOptional.isEmpty()){
            int number = screenRepository.findById(screenId).get().getSeats().stream().max((a,b) -> Integer.compare(a.getNumber(), b.getNumber())).get().getNumber()+1;
            Seat seat = new Seat(number, row, col, seatType);
            seatRepository.save(seat);
            screenRepository.findById(screenId).get().AddSeat(seat);
        }else{
            throw new Exception("Can't Put seat at this position");
        }
    }
    public Theater GetTheaterById(long theaterId){
        return theaterRepository.findById(theaterId).get();
    }
}

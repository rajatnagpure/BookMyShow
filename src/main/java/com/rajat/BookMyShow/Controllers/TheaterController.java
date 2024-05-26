package com.rajat.BookMyShow.Controllers;

import com.rajat.BookMyShow.Models.Theater;
import com.rajat.BookMyShow.Services.RegionService;
import com.rajat.BookMyShow.Services.TheaterService;
import com.rajat.BookMyShow.dto.AddScreenDTO;
import com.rajat.BookMyShow.dto.AddSeatDTO;
import com.rajat.BookMyShow.dto.AddTheaterDTO;
import com.rajat.BookMyShow.dto.GetTheaterDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController("/theater")
public class TheaterController {
    @Autowired
    private TheaterService theaterService;

    @PostMapping("/add")
    public ResponseEntity addTheater(@RequestBody AddTheaterDTO addTheaterDTO){
        return ResponseEntity.ok(theaterService.AddTheater(addTheaterDTO.getName(),addTheaterDTO.getRegionId()));
    }
    @PostMapping("/addScreen")
    public ResponseEntity addScreen(@RequestBody AddScreenDTO addScreenDTO){
        return ResponseEntity.ok(theaterService.AddScreen(addScreenDTO.getName(), addScreenDTO.getFeatures(),addScreenDTO.getTheaterId()));
    }
    @PostMapping("/addSeat")
    public ResponseEntity addSeat(@RequestBody AddSeatDTO addSeatDTO) throws Exception{
        theaterService.AddSeat(addSeatDTO.getScreenId(), addSeatDTO.getRow(), addSeatDTO.getCol(), addSeatDTO.getSeatType());
        return ResponseEntity.ok("Success!");
    }
    @GetMapping("theater")
    public ResponseEntity getTheaterById(@PathVariable long theaterId){
        Theater theater = theaterService.GetTheaterById(theaterId);
        GetTheaterDTO getTheaterDTO = new GetTheaterDTO(theater.getName(), theater.getScreens());
        return ResponseEntity.ok(getTheaterDTO);
    }
}

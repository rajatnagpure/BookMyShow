package com.rajat.BookMyShow.Controllers;

import com.rajat.BookMyShow.Services.MovieService;
import com.rajat.BookMyShow.dto.AddMovieDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController("/movie")
public class MovieController {
    @Autowired
    private MovieService movieService;

    @PostMapping("/addMovie")
    public ResponseEntity addMovie(@RequestBody AddMovieDTO addMovieDTO){
        return ResponseEntity.ok(movieService.AddMovie(addMovieDTO.getName(), addMovieDTO.getFeatures(), addMovieDTO.getDuration()));
    }
}

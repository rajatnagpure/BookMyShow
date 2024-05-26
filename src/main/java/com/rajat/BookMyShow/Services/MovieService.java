package com.rajat.BookMyShow.Services;

import com.rajat.BookMyShow.Enums.Feature;
import com.rajat.BookMyShow.Models.Movie;
import com.rajat.BookMyShow.Repositories.MovieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.Duration;
import java.util.List;

@Service
public class MovieService {
    @Autowired
    private MovieRepository movieRepository;
    public long AddMovie(String name, List<Feature> features, Duration duration){
        Movie movie = new Movie(name, features, duration);
        movieRepository.save(movie);
        return movie.getId();
    }
}

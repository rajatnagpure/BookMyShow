package com.rajat.BookMyShow.dto;

import com.rajat.BookMyShow.Enums.Feature;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.time.Duration;
import java.util.List;

@Setter
@Getter
public class AddMovieDTO {
    private String name;
    private List<Feature> features;
    private Duration duration;
}

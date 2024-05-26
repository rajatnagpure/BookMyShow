package com.rajat.BookMyShow.dto;

import com.rajat.BookMyShow.Enums.Feature;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;
import java.util.List;

@Getter
@Setter
public class CreateShowDTO {
    private long screenId;
    private Date date;
    private long movieId;
    private List<Feature> features;
}

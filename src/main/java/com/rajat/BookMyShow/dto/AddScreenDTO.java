package com.rajat.BookMyShow.dto;

import com.rajat.BookMyShow.Enums.Feature;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class AddScreenDTO {
    private String name;
    private List<Feature> features;
    private long theaterId;
}

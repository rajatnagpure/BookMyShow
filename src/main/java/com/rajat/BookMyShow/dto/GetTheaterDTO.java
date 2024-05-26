package com.rajat.BookMyShow.dto;

import com.rajat.BookMyShow.Models.Screen;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
public class GetTheaterDTO {
    private String name;
    private List<Screen> screens;
}

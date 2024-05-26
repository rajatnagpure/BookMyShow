package com.rajat.BookMyShow.dto;

import com.rajat.BookMyShow.Models.Theater;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Setter
@Getter
@AllArgsConstructor
public class GetRegionDTO {
    private String name;
    private List<Theater> theaters;
}

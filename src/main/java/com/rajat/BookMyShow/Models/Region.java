package com.rajat.BookMyShow.Models;

import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@Entity
public class Region extends BaseModel{
    private String name;
    @OneToMany
    private List<Theater> theaters;
    public Region(String name){
        this.name = name;
    }
    public void AddTheater(Theater theater){
        theaters.add(theater);
        super.Update();
    }
}

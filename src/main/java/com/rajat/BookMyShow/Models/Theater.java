package com.rajat.BookMyShow.Models;

import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@Entity
public class Theater extends BaseModel{
    private String name;
    @OneToMany
    private List<Screen> screens;
    public Theater(String name){
        this.name = name;
    }
    public void AddScreen(Screen screen){
        screens.add(screen);
        super.Update();
    }
}

package com.rajat.BookMyShow.Models;

import com.rajat.BookMyShow.Enums.Feature;
import jakarta.persistence.ElementCollection;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.AllArgsConstructor;
import lombok.Setter;
import lombok.Getter;

import java.time.Duration;
import java.util.List;

@Setter
@Getter
@Entity
@AllArgsConstructor
public class Movie extends BaseModel{
    private String name;
    @ElementCollection
    @Enumerated(EnumType.STRING)
    private List<Feature> features;
    private Duration duration;
    public void AddFeature(Feature feature){
        features.add(feature);
    }
}

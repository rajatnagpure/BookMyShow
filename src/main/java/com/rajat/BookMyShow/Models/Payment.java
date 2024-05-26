package com.rajat.BookMyShow.Models;

import jakarta.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@AllArgsConstructor
public class Payment extends BaseModel{
    private String provider;
    private String referenceId;
    private boolean isSuccessful;
    private float amount;
}

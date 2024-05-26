package com.rajat.BookMyShow.Models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
@MappedSuperclass
public class BaseModel {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "ID")
    private long id;
    @Column(name = "Create_On")
    private Date createdOn;
    @Column(name = "Updated_On")
    private Date updatedOn;
    public void Update(){
        updatedOn = new Date();
    }
}

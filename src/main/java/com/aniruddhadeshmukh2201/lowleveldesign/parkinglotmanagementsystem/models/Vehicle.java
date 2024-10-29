package com.aniruddhadeshmukh2201.lowleveldesign.parkinglotmanagementsystem.models;

import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.Setter;

@Entity(name = "Vehicles")
@Getter
@Setter
public class Vehicle extends BaseModel {
    
    private String licenseNumber;

    private VehicleType vehicleType;

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false) // foreign key column
    private User user;

}


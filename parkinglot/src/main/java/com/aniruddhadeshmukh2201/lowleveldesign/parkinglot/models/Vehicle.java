package com.aniruddhadeshmukh2201.lowleveldesign.parkinglot.models;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Vehicle extends BaseModel {
    
    private String licenseNumber;

    private VehicleType vehicleType;

    private User user;

}


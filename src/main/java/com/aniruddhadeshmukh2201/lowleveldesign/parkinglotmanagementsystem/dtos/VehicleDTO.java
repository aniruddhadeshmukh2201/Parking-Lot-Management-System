package com.aniruddhadeshmukh2201.lowleveldesign.parkinglotmanagementsystem.dtos;

import com.aniruddhadeshmukh2201.lowleveldesign.parkinglotmanagementsystem.models.VehicleType;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class VehicleDTO {
    
    private UserDTO userDTO;

    private String licenseNumber;

    private VehicleType vehicleType;
}

package com.aniruddhadeshmukh2201.lowleveldesign.parkinglotmanagementsystem.dtos;

import com.aniruddhadeshmukh2201.lowleveldesign.parkinglotmanagementsystem.models.VehicleType;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class ParkingSpotDTO {
    private Integer spotNumber;
    private Boolean isFree;
    private VehicleType supportedVehicleType;
    private Boolean hasCharger;
}

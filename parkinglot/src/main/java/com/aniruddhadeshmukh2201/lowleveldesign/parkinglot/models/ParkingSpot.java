package com.aniruddhadeshmukh2201.lowleveldesign.parkinglot.models;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ParkingSpot extends BaseModel {
    
    private Integer spotNumber;
    
    private Boolean isFree;

    private Vehicle vehicle;
    
    private VehicleType supportedVehicleType;
    
    private Boolean hasCharger;

    private ParkingLot parkingLot;

    private ParkingFloor parkingFloor;

}

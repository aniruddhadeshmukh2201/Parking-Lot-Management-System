package com.aniruddhadeshmukh2201.lowleveldesign.parkinglotmanagementsystem.models;

import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;


@Entity(name = "ParkingSpots")
@Getter
@Setter
@Builder
public class ParkingSpot extends BaseModel {
    
    private Integer spotNumber;
    
    private Boolean isFree;
    
    private VehicleType supportedVehicleType;
    
    private Boolean hasCharger;

    @ManyToOne
    @JoinColumn(name = "parking_lot_id", nullable = false) // foreign key column
    private ParkingLot parkingLot;

    @ManyToOne
    @JoinColumn(name = "parking_floor_id", nullable = false) // foreign key column
    private ParkingFloor parkingFloor;

}

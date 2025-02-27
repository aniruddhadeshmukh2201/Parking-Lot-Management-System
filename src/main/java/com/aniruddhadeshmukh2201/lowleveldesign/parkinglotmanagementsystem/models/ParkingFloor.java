package com.aniruddhadeshmukh2201.lowleveldesign.parkinglotmanagementsystem.models;

import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;


@Entity(name = "ParkingFloors")
@Getter
@Setter
@Builder
public class ParkingFloor extends BaseModel {

    private Integer floorNumber;

    @ManyToOne
    @JoinColumn(name = "parking_lot_id", nullable = false) // foreign key column
    private ParkingLot parkingLot;
}

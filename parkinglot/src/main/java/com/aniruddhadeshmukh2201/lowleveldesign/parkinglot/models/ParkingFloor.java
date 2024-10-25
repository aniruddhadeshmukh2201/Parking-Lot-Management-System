package com.aniruddhadeshmukh2201.lowleveldesign.parkinglot.models;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ParkingFloor extends BaseModel {

    private Integer floorNumber;

    private ParkingLot parkingLot;

}

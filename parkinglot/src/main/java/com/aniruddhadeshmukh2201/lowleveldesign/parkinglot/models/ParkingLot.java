package com.aniruddhadeshmukh2201.lowleveldesign.parkinglot.models;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ParkingLot extends BaseModel {

    private String name;

    private String Address;

    private String Latitude;

    private String Longitude;

}

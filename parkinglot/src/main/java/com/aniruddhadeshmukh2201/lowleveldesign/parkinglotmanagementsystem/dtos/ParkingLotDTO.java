package com.aniruddhadeshmukh2201.lowleveldesign.parkinglotmanagementsystem.dtos;

import java.util.List;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ParkingLotDTO {
    private String name;

    private String Address;

    private String Latitude;

    private String Longitude;

    private List<EntryGateDTO> entryGates;

    private List<ExitGateDTO> exitGates;

    private List<ParkingFloorDTO> parkingFloors;

}

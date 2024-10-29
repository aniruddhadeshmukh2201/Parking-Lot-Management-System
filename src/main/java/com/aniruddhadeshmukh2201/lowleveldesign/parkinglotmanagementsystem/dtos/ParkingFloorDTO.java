package com.aniruddhadeshmukh2201.lowleveldesign.parkinglotmanagementsystem.dtos;

import java.util.List;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ParkingFloorDTO {
    private Integer floorNumber;
    private List<ParkingSpotDTO> parkingSpots;
}

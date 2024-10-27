package com.aniruddhadeshmukh2201.lowleveldesign.parkinglotmanagementsystem.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import com.aniruddhadeshmukh2201.lowleveldesign.parkinglotmanagementsystem.dtos.ParkingSpotBookingsDTO;
import com.aniruddhadeshmukh2201.lowleveldesign.parkinglotmanagementsystem.services.BookingService;


import org.springframework.web.bind.annotation.PathVariable;

@RestController("/api/spot")
public class ParkingSpotController {
    
    @Autowired
    private BookingService bookingService;

    
    public ResponseEntity<List<ParkingSpotBookingsDTO>> getParkingSpotAvailability(@PathVariable Long Id) { 
        try {
            return new ResponseEntity<>(bookingService.getParkingSpotAvailability(Id), HttpStatus.OK);
        } catch(Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    // TODO : api to get parking spot details
    
}

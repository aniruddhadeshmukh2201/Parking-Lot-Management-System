package com.aniruddhadeshmukh2201.lowleveldesign.parkinglot.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.aniruddhadeshmukh2201.lowleveldesign.parkinglot.services.ParkingLotService;

@RestController
@RequestMapping("/api/parkinglot")
public class ParkingLotController {
    
    @Autowired
    private ParkingLotService parkingLotService;

    // Get all parking spots or specific parking lot details
    @GetMapping
    public void getParkingLot() {
        // Implementation to retrieve parking lot details
    }

    // Book a parking spot at the entry gate
    @PostMapping("/spots/book")
    public void bookParkingSpot() {
        // Implementation to book a parking spot
    }

    // Check in a vehicle
    @PostMapping("/entrygate/checkin")
    public void checkIn() {
        // Implementation for vehicle check-in
    }

    // Check out a vehicle
    @PostMapping("/exitgate/checkout")
    public void checkOut() {
        // Implementation for vehicle check-out
    }
}

package com.aniruddhadeshmukh2201.lowleveldesign.parkinglotmanagementsystem.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.aniruddhadeshmukh2201.lowleveldesign.parkinglotmanagementsystem.models.ExitGate;
import com.aniruddhadeshmukh2201.lowleveldesign.parkinglotmanagementsystem.services.ExitGateService;

@RestController("/api/exitgate")
public class ExitGateController {
    
    @Autowired
    ExitGateService exitGateService;

    // Check out a vehicle
    @PostMapping("/exit/checkout")
    public ResponseEntity<ExitGate> checkOut() {
        try {
            return new ResponseEntity<>(exitGateService.checkOut(), HttpStatus.OK);
        } catch(Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    

}

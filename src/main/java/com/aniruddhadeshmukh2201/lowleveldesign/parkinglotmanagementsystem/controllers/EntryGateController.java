package com.aniruddhadeshmukh2201.lowleveldesign.parkinglotmanagementsystem.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.aniruddhadeshmukh2201.lowleveldesign.parkinglotmanagementsystem.models.EntryGate;
import com.aniruddhadeshmukh2201.lowleveldesign.parkinglotmanagementsystem.services.EntryGateService;

@RestController("/api/entrygate")
public class EntryGateController {
    
    @Autowired
    EntryGateService entryGateService;

    
    // Check in a vehicle
    @PostMapping("/entry/checkin")
    public ResponseEntity<EntryGate> checkIn() {
        try {
            return new ResponseEntity<>(entryGateService.checkIn(), HttpStatus.OK);
        } catch(Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}

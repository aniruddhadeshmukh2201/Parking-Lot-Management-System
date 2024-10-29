package com.aniruddhadeshmukh2201.lowleveldesign.parkinglotmanagementsystem.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.aniruddhadeshmukh2201.lowleveldesign.parkinglotmanagementsystem.dtos.BookingDTO;
import com.aniruddhadeshmukh2201.lowleveldesign.parkinglotmanagementsystem.models.Booking;
import com.aniruddhadeshmukh2201.lowleveldesign.parkinglotmanagementsystem.services.ParkingSpotService;

import jakarta.persistence.EntityNotFoundException;

@RestController("/api/booking")
public class BookingController {


    @Autowired
    private ParkingSpotService parkingSpotService;


    @PostMapping("/book/{Id}")
    public ResponseEntity<Booking> bookParkingSpot(@PathVariable Long Id, @RequestBody BookingDTO bookingDTO) {
        try {
            return new ResponseEntity<>(parkingSpotService.bookParkingSpot(Id, bookingDTO), HttpStatus.OK);
        } catch( EntityNotFoundException e) {
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        } catch( IllegalStateException e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        } catch(Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    // TODO : cancel booking api

    // TODO : get booking details api

    // TODO : get all bookings for a user api

    
}

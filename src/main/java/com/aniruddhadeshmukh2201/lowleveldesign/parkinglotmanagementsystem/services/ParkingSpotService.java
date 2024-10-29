package com.aniruddhadeshmukh2201.lowleveldesign.parkinglotmanagementsystem.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.aniruddhadeshmukh2201.lowleveldesign.parkinglotmanagementsystem.dtos.BookingDTO;
import com.aniruddhadeshmukh2201.lowleveldesign.parkinglotmanagementsystem.models.Booking;
import com.aniruddhadeshmukh2201.lowleveldesign.parkinglotmanagementsystem.models.ParkingSpot;
import com.aniruddhadeshmukh2201.lowleveldesign.parkinglotmanagementsystem.repositories.BookingRepository;
import com.aniruddhadeshmukh2201.lowleveldesign.parkinglotmanagementsystem.repositories.ParkingSpotRepository;

import jakarta.persistence.EntityNotFoundException;

@Service
public class ParkingSpotService {
    
    @Autowired
    private BookingRepository bookingRepository;

    @Autowired
    private ParkingSpotRepository parkingSpotRepository;

    public Booking bookParkingSpot(Long parkingSpotId, BookingDTO bookingDTO) {

        ParkingSpot parkingSpot = parkingSpotRepository.findById(parkingSpotId)
            .orElseThrow(() -> new EntityNotFoundException("Parking spot not found"));
    
        if (!parkingSpot.getIsFree()) {
            throw new IllegalStateException("Parking spot with ID " + parkingSpotId + " is already booked.");
        }

        parkingSpot.setIsFree(false);
        parkingSpotRepository.save(parkingSpot); // Save the updated status in the database

        Booking booking = bookingRepository.save(
                Booking.builder()
                    .parkingSpot(parkingSpot)
                    .startTime(bookingDTO.getStartTime())
                    .endTime(bookingDTO.getEndTime()) // 1 hour
                    .build()
        );

        return booking;
    }

    
}

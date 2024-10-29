package com.aniruddhadeshmukh2201.lowleveldesign.parkinglotmanagementsystem.services;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.aniruddhadeshmukh2201.lowleveldesign.parkinglotmanagementsystem.dtos.ParkingSpotBookingsDTO;
import com.aniruddhadeshmukh2201.lowleveldesign.parkinglotmanagementsystem.models.Booking;
import com.aniruddhadeshmukh2201.lowleveldesign.parkinglotmanagementsystem.models.ParkingSpot;
import com.aniruddhadeshmukh2201.lowleveldesign.parkinglotmanagementsystem.repositories.BookingRepository;
import com.aniruddhadeshmukh2201.lowleveldesign.parkinglotmanagementsystem.repositories.ParkingSpotRepository;

@Service
public class BookingService {
    

    @Autowired
    private ParkingSpotRepository parkingSpotRepository;

    @Autowired
    private BookingRepository bookingRepository;


    public List<ParkingSpotBookingsDTO> getParkingSpotAvailability(Long parkingSpotId) {
        ParkingSpot parkingSpot = parkingSpotRepository.findById(parkingSpotId)
                .orElseThrow(() -> new RuntimeException("Parking spot not found"));

        // Fetch bookings that are upcoming (end time > current time)
        LocalDateTime now = LocalDateTime.now();
        List<Booking> upcomingBookings = bookingRepository.findByParkingSpotAndEndTimeAfter(parkingSpot, now);

        // Convert each booking to a simplified DTO
        return upcomingBookings.stream()
            .map(booking -> ParkingSpotBookingsDTO.builder()
                .startTime(booking.getStartTime())
                .endTime(booking.getEndTime())
                .isBooked(true)
                .build())
                .collect(Collectors.toList());
    }
}

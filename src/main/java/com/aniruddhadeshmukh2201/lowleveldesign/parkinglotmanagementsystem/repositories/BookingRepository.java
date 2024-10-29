package com.aniruddhadeshmukh2201.lowleveldesign.parkinglotmanagementsystem.repositories;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.aniruddhadeshmukh2201.lowleveldesign.parkinglotmanagementsystem.models.Booking;
import com.aniruddhadeshmukh2201.lowleveldesign.parkinglotmanagementsystem.models.ParkingSpot;

@Repository
public interface BookingRepository extends JpaRepository<Booking, Long> {
    List<Booking> findByParkingSpotAndEndTimeAfter(ParkingSpot parkingSpot, LocalDateTime endTime);

}

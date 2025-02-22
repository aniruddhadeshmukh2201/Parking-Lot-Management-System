package com.aniruddhadeshmukh2201.lowleveldesign.parkinglotmanagementsystem.models;

import java.time.LocalDateTime;

import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity(name = "Bookings")
@Builder
public class Booking extends BaseModel {

    //this is for the guy who booked the parking spot
    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false) // foreign key column
    private User user;

    @ManyToOne
    @JoinColumn(name = "parking_spot_id", nullable = false) // foreign key column
    private ParkingSpot parkingSpot;

    @ManyToOne
    @JoinColumn(name = "vehicle_id", nullable = false) // foreign key column
    private Vehicle vehicle;


    private LocalDateTime startTime;
    
    private LocalDateTime endTime;

}

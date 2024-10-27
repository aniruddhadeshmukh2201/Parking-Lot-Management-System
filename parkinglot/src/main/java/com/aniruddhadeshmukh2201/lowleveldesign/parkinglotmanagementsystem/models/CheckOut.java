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
@Entity(name = "CheckOuts")
@Builder
public class CheckOut {
    
    @ManyToOne
    @JoinColumn(name = "booking_id", nullable = false) // foreign key column
    private Booking booking;

    private LocalDateTime checkOutTime;

    @ManyToOne
    @JoinColumn(name = "exitgate_id", nullable = false) // foreign key column
    private ExitGate exitGate;
}

package com.aniruddhadeshmukh2201.lowleveldesign.parkinglotmanagementsystem.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.aniruddhadeshmukh2201.lowleveldesign.parkinglotmanagementsystem.models.Vehicle;

@Repository
public interface VehicleRepository extends JpaRepository<Vehicle, Long> {
    
}

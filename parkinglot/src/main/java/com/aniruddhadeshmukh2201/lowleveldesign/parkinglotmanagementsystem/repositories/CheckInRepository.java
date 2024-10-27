package com.aniruddhadeshmukh2201.lowleveldesign.parkinglotmanagementsystem.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.aniruddhadeshmukh2201.lowleveldesign.parkinglotmanagementsystem.models.CheckIn;

@Repository
public interface CheckInRepository extends JpaRepository<CheckIn, Long> {
    
}

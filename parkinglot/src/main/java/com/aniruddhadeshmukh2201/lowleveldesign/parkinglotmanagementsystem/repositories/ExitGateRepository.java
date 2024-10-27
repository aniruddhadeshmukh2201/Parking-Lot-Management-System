package com.aniruddhadeshmukh2201.lowleveldesign.parkinglotmanagementsystem.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.aniruddhadeshmukh2201.lowleveldesign.parkinglotmanagementsystem.models.ExitGate;

@Repository
public interface ExitGateRepository extends JpaRepository<ExitGate, Long> {
    
}

package com.aniruddhadeshmukh2201.lowleveldesign.parkinglotmanagementsystem.repositories;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.aniruddhadeshmukh2201.lowleveldesign.parkinglotmanagementsystem.models.ParkingLot;

@Repository
public interface ParkingLotRepository extends JpaRepository<ParkingLot, Long> {
    Page<ParkingLot> findAll(Pageable pageable);

}

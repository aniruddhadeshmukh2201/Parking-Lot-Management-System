package com.aniruddhadeshmukh2201.lowleveldesign.parkinglotmanagementsystem.models;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Entity(name = "ParkingLots")
@Getter
@Setter
@Builder
public class ParkingLot extends BaseModel {

    private String name;

    private String Address;

    private String Latitude;

    private String Longitude;

    @OneToMany(mappedBy = "parkingLot", cascade = CascadeType.ALL)
    private List<EntryGate> entryGates;

    @OneToMany(mappedBy = "parkingLot", cascade = CascadeType.ALL)
    private List<EntryGate> exitGates;

    @OneToMany(mappedBy = "parkingLot", cascade = CascadeType.ALL)
    private List<ParkingFloor> parkingFloors;

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false) // foreign key column
    private User user;

}


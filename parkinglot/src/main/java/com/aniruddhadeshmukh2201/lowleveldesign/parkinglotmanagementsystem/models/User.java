package com.aniruddhadeshmukh2201.lowleveldesign.parkinglotmanagementsystem.models;


import jakarta.persistence.Entity;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Entity(name = "Users")
@Getter
@Setter
@Builder
public class User extends BaseModel {
    private String firstName;
    private String lastName;
    private String email;
    private String password;
    private String mobileNumber;
    private String countryCode;
    private UserRole userRole;
}
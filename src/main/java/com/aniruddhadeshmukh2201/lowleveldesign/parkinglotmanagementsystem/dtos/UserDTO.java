package com.aniruddhadeshmukh2201.lowleveldesign.parkinglotmanagementsystem.dtos;

import com.aniruddhadeshmukh2201.lowleveldesign.parkinglotmanagementsystem.models.UserRole;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class UserDTO {
    private String firstName;
    private String lastName;
    private String email;
    private String password;
    private String mobileNumber;
    private String countryCode;
    private UserRole userRole;
}

package com.aniruddhadeshmukh2201.lowleveldesign.parkinglot.models;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class User extends BaseModel {
    private String firstName;
    private String lastName;
    private String email;
    private String mobileNumber;
    private String countryCode;
    private UserRole userRole;
}

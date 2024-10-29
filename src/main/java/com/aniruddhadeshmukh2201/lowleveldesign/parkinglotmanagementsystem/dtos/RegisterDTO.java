package com.aniruddhadeshmukh2201.lowleveldesign.parkinglotmanagementsystem.dtos;

import com.aniruddhadeshmukh2201.lowleveldesign.parkinglotmanagementsystem.models.UserRole;

import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class RegisterDTO {
    @NotBlank
    private String lastName;

    @NotBlank
    private String firstName;

    @NotBlank
    private String email;

    @NotBlank
    private String password;

    @NotBlank
    private String mobileNumber;

    @NotBlank
    private String countryCode;

    @NotBlank
    private UserRole userRole;
}

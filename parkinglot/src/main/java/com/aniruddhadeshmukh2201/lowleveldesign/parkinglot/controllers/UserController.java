package com.aniruddhadeshmukh2201.lowleveldesign.parkinglot.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import com.aniruddhadeshmukh2201.lowleveldesign.parkinglot.services.UserService;

@RestController
public class UserController {
    
    @Autowired
    private UserService userService;

    public void registerUser() {

    }

    public void loginUser() {

    }

    public void logoutUser() {

    }

    public void deleteUser() {

    }

    public void assignRole() {

    }

}

package com.aniruddhadeshmukh2201.lowleveldesign.parkinglotmanagementsystem.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.aniruddhadeshmukh2201.lowleveldesign.parkinglotmanagementsystem.dtos.EditUserDTO;
import com.aniruddhadeshmukh2201.lowleveldesign.parkinglotmanagementsystem.models.User;
import com.aniruddhadeshmukh2201.lowleveldesign.parkinglotmanagementsystem.services.UserService;

@RestController
@RequestMapping("/api/profile")
public class ProfileController {
   

    @Autowired
    private UserService userService;


    @PutMapping("/deactivate/{userId}")
    public ResponseEntity<String> deactivateUser(@PathVariable Long userId) {
        try {
            userService.deactivateUserById(userId); // Call the service method to delete the user
            return new ResponseEntity<>("User deactivated successfully.", HttpStatus.OK);
        } catch (IllegalArgumentException e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>("An error occurred while deleting the user.", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping("/edit/{Id}")
    public ResponseEntity<User> editUser(@PathVariable Long Id, @RequestBody EditUserDTO editUserDTO) {
        try {
            return new ResponseEntity<>(userService.editUser(Id, editUserDTO), HttpStatus.OK);
        } catch (IllegalArgumentException e) {
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    // TODO : api to get user details

}

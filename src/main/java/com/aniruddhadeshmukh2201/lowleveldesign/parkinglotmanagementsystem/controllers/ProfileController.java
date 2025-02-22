package com.aniruddhadeshmukh2201.lowleveldesign.parkinglotmanagementsystem.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.aniruddhadeshmukh2201.lowleveldesign.parkinglotmanagementsystem.dtos.EditUserDTO;
import com.aniruddhadeshmukh2201.lowleveldesign.parkinglotmanagementsystem.dtos.UserDTO;
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

    @PutMapping("/edit/{id}")
    public ResponseEntity<UserDTO> editUser(@PathVariable Long id, @RequestBody EditUserDTO editUserDTO) {
        try {
            User updatedUser = userService.editUser(id, editUserDTO);

            // Convert User entity to UserDTO
            UserDTO userDTO = new UserDTO();
            userDTO.setFirstName(updatedUser.getFirstName());
            userDTO.setLastName(updatedUser.getLastName());
            userDTO.setEmail(updatedUser.getEmail());
            userDTO.setMobileNumber(updatedUser.getMobileNumber());
            userDTO.setCountryCode(updatedUser.getCountryCode());
            userDTO.setUserRole(updatedUser.getUserRole());

            return new ResponseEntity<>(userDTO, HttpStatus.OK);
        } catch (IllegalArgumentException e) {
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/me")
    public ResponseEntity<UserDTO> getCurrentUser(@AuthenticationPrincipal UserDetails userDetails) {
        try {
            if (userDetails == null) {
                return new ResponseEntity<>(null, HttpStatus.UNAUTHORIZED);
            }

            // Load the user from the database using the email
            User user = userService.getUserByEmail(userDetails.getUsername());
            if (user == null) {
                return new ResponseEntity<>(null, HttpStatus.UNAUTHORIZED);
            }

            // Convert User entity to UserDTO while excluding sensitive fields
            UserDTO userDTO = new UserDTO();
            userDTO.setFirstName(user.getFirstName());
            userDTO.setLastName(user.getLastName());
            userDTO.setEmail(user.getEmail());
            userDTO.setMobileNumber(user.getMobileNumber());
            userDTO.setCountryCode(user.getCountryCode());
            userDTO.setUserRole(user.getUserRole());

            return new ResponseEntity<>(userDTO, HttpStatus.OK);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}

package com.aniruddhadeshmukh2201.lowleveldesign.parkinglotmanagementsystem.services;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.aniruddhadeshmukh2201.lowleveldesign.parkinglotmanagementsystem.dtos.EditUserDTO;
import com.aniruddhadeshmukh2201.lowleveldesign.parkinglotmanagementsystem.dtos.RegisterDTO;
import com.aniruddhadeshmukh2201.lowleveldesign.parkinglotmanagementsystem.models.User;
import com.aniruddhadeshmukh2201.lowleveldesign.parkinglotmanagementsystem.repositories.UserRepository;

@Service
public class UserService implements UserDetailsService{

    @Autowired 
    private UserRepository userRepository;


    @Autowired
    private PasswordEncoder passwordEncoder;

    public User registerUser( RegisterDTO registerDTO) {
        if (userRepository.existsByEmail(registerDTO.getEmail())) {
            throw new IllegalArgumentException("Email is already in use.");
        }
        if (userRepository.existsByMobileNumber(registerDTO.getMobileNumber())) {
            throw new IllegalArgumentException("Mobile Number is already in use.");
        }

        String hashedPassword = passwordEncoder.encode(registerDTO.getPassword());

        User user = User.builder()
        .email(registerDTO.getEmail())
        .password(hashedPassword)
        .firstName(registerDTO.getFirstName())
        .lastName(registerDTO.getLastName())
        .userRole(registerDTO.getUserRole())
        .mobileNumber(registerDTO.getMobileNumber())
        .countryCode(registerDTO.getCountryCode())
        .build();
        return userRepository.save(user);
    }

    public User login(String email, String password) {
        User user = userRepository.findByEmail(email);
        System.out.println("User: " + user);
        if (user == null) {
            throw new IllegalArgumentException("User not found.");
        }
        
        // Compare hashed password
        if (!passwordEncoder.matches(password, user.getPassword())) {
            throw new IllegalArgumentException("Invalid password.");
        }
        
        return user;
    }


    public void deactivateUserById(Long userId) {
        User user = userRepository.findById(userId).orElse(null);
        if (user == null) {
            throw new IllegalArgumentException("User not found.");
        }
        user.setDeleted(true);
        userRepository.save(user); 
    }

    public User editUser(Long Id, EditUserDTO editUserDTO) {
        System.out.println("Id:::::::::::::::" + Id);
        User user  = userRepository.findById(Id).orElse(null);
        System.out.println("User:::::::::::::::" + user);
        if (user == null) {
            throw new IllegalArgumentException("User not found.");
        }
        user.setFirstName(editUserDTO.getFirstName());
        user.setLastName(editUserDTO.getLastName());
        return userRepository.save(user);
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userRepository.findByEmail(username); // Or find by any field, e.g., username
        if (user == null) {
            throw new UsernameNotFoundException("User not found with username: " + username);
        }
        return new org.springframework.security.core.userdetails.User(
                user.getEmail(), 
                user.getPassword(), 
                new ArrayList<>()); // Or add authorities/roles
    }
}

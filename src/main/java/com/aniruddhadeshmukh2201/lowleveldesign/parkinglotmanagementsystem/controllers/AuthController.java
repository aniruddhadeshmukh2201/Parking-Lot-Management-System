package com.aniruddhadeshmukh2201.lowleveldesign.parkinglotmanagementsystem.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.aniruddhadeshmukh2201.lowleveldesign.parkinglotmanagementsystem.dtos.EditUserDTO;
import com.aniruddhadeshmukh2201.lowleveldesign.parkinglotmanagementsystem.dtos.LoginDTO;
import com.aniruddhadeshmukh2201.lowleveldesign.parkinglotmanagementsystem.dtos.RegisterDTO;
import com.aniruddhadeshmukh2201.lowleveldesign.parkinglotmanagementsystem.models.User;
import com.aniruddhadeshmukh2201.lowleveldesign.parkinglotmanagementsystem.services.UserService;
import com.aniruddhadeshmukh2201.lowleveldesign.parkinglotmanagementsystem.util.JwtTokenUtil;

import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@RestController
@RequestMapping("/api/auth")
public class AuthController {

    @Autowired
    private UserService userService;

    @Autowired
    private JwtTokenUtil jwtTokenUtil;

    @PostMapping("/register")
    public ResponseEntity<Void> registerUser(@RequestBody RegisterDTO registerDTO) {
        try {
            userService.registerUser(registerDTO);
            return new ResponseEntity<>(null, HttpStatus.CREATED);
        } catch (IllegalArgumentException e) {
            return new ResponseEntity<>(null, HttpStatus.CONFLICT);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping("/login")
    public ResponseEntity<Void> loginUser(@RequestBody LoginDTO loginDTO, HttpServletResponse response) {
        try {
            userService.login(loginDTO.getEmail(), loginDTO.getPassword());

            String accessToken = jwtTokenUtil.generateAccessToken(loginDTO.getEmail());
            String refreshToken = jwtTokenUtil.generateRefreshToken(loginDTO.getEmail());

            Cookie accessTokenCookie = new Cookie("accessToken", accessToken);
            accessTokenCookie.setHttpOnly(true);
            accessTokenCookie.setSecure(true); // Only send over HTTPS
            accessTokenCookie.setPath("/");
            accessTokenCookie.setMaxAge(5 * 60); // 5 minutes

            Cookie refreshTokenCookie = new Cookie("refreshToken", refreshToken);
            refreshTokenCookie.setHttpOnly(true);
            refreshTokenCookie.setSecure(true);
            refreshTokenCookie.setPath("/");
            refreshTokenCookie.setMaxAge(30 * 60); // 30 minutes

            response.addCookie(accessTokenCookie);
            response.addCookie(refreshTokenCookie);

            return ResponseEntity.ok().build();
        } catch (IllegalArgumentException e) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @GetMapping("/logout")
    public ResponseEntity<String> logoutUser(HttpServletRequest request, HttpServletResponse response) {
        try {
            // Clear the access token cookie
            Cookie accessTokenCookie = new Cookie("accessToken", null);
            accessTokenCookie.setPath("/");
            accessTokenCookie.setHttpOnly(true);
            accessTokenCookie.setSecure(true);
            accessTokenCookie.setMaxAge(0);

            // Clear the refresh token cookie
            Cookie refreshTokenCookie = new Cookie("refreshToken", null);
            refreshTokenCookie.setPath("/");
            refreshTokenCookie.setHttpOnly(true);
            refreshTokenCookie.setSecure(true);
            refreshTokenCookie.setMaxAge(0);

            // Add cookies to response to remove them from the browser
            response.addCookie(accessTokenCookie);
            response.addCookie(refreshTokenCookie);

            return new ResponseEntity<>("Logged out successfully.", HttpStatus.OK);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>("An error occurred while logging out.", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

}

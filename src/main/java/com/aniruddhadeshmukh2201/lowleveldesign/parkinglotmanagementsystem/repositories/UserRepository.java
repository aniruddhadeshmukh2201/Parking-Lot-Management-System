package com.aniruddhadeshmukh2201.lowleveldesign.parkinglotmanagementsystem.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.aniruddhadeshmukh2201.lowleveldesign.parkinglotmanagementsystem.models.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long>{
    public boolean existsByEmail(String email);

    public boolean existsByMobileNumber(String mobileNumber);

    public User findByEmail(String email);
}

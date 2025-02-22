package com.aniruddhadeshmukh2201.lowleveldesign.parkinglotmanagementsystem.util;

import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;
import java.util.Base64;
import javax.crypto.SecretKey;

public class GenerateJwtSecretKey {
    public static void main(String[] args) {
        SecretKey key = Keys.secretKeyFor(SignatureAlgorithm.HS512); // Secure key
        String encodedKey = Base64.getEncoder().encodeToString(key.getEncoded());
        System.out.println("Generated Secret Key: " + encodedKey);
    }
}

package com.aniruddhadeshmukh2201.lowleveldesign.parkinglotmanagementsystem;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;

@SpringBootTest
@TestPropertySource(properties = {
    "spring.security.jwt.secret=testsecretkeytestsecretkeytestsecretkeytestsecretkey",
    "spring.security.jwt.access-token-validity=300000",
    "spring.security.jwt.refresh-token-validity=1800000"
})
class ParkinglotApplicationTests {

	// @Test
	// void contextLoads() {
	// }

}

package com.furnize.bookings;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

@SpringBootTest
@ActiveProfiles("test")  // Uses application-test.properties
class BookingsApplicationTests {

    @Test
    void contextLoads() {
        // Simply checks if Spring context loads
    }
}
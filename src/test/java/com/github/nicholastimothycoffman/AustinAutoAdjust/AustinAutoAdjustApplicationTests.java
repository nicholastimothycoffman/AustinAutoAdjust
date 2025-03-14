package com.github.nicholastimothycoffman.AustinAutoAdjust;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.kafka.test.context.EmbeddedKafka;

/**
 * Test class for the AustinAutoAdjust Spring Boot application.
 * Ensures that the application context loads correctly and Kafka is set up properly.
 */
@SpringBootTest
@EmbeddedKafka(partitions = 1, topics = { "premium-changes" })
class AustinAutoAdjustApplicationTests {
   
	/**
	 * Tests if the Spring application context loads successfully.
	 * This helps verify that the application's configuration is correct.
	 */ 
    	@Test
    	void contextLoads() {
        	// Test if the Spring context loads successfully
    	}
}


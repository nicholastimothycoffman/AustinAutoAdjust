package com.github.nicholastimothycoffman.AustinAutoAdjust;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.kafka.test.context.EmbeddedKafka;

@SpringBootTest
@EmbeddedKafka(partitions = 1, topics = { "premium-changes" })
class AustinAutoAdjustApplicationTests {
    
    	@Test
    	void contextLoads() {
        	// Test if the Spring context loads successfully
    	}
}


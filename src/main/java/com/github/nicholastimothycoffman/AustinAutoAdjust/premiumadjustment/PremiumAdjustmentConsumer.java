package com.github.nicholastimothycoffman.AustinAutoAdjust.premiumadjustment.kafka;

import com.github.nicholastimothycoffman.AustinAutoAdjust.premiumadjustment.model.PremiumAdjustment;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

/**
 * Consumer class for handling Kafka messages related to premium adjustments.
 * Listens to the "premium-changes" topic and processes incoming messages
 * that contain premium adjustment details.
 */
@Service
public class PremiumAdjustmentConsumer {

	/**
 	 * Listens to the "premium-changes" Kafka topic and processes premium adjustment messages.
	 * Each time a message is published to this topic, this method is triggered.
	 *
	 * @param adjustment The premium adjustment object received from Kafka.
	 */
    	@KafkaListener(topics = "premium-changes", groupId = "premium-group")
    	public void listenPremiumChanges(PremiumAdjustment adjustment) {
        	System.out.println("Received Premium Adjustment: " + adjustment);
    	}
}


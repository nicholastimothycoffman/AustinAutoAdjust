package com.github.nicholastimothycoffman.AustinAutoAdjust.premiumadjustment.kafka;

import com.github.nicholastimothycoffman.AustinAutoAdjust.premiumadjustment.model.PremiumAdjustment;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

/**
 * Kafka producer service for sending premium adjustment messages.
 * This class is responsible for publishing premium adjustment events to the Kafka topic "premium-changes".
 */
@Service
public class PremiumAdjustmentProducer {

	/**
	 * Kafka template for sending messages to the Kafka topic.
	 */
    	private final KafkaTemplate<String, PremiumAdjustment> kafkaTemplate;

	/**
	 * Constructs a PremiumAdjustmentProducer with the specified Kafka template.
	 *
	 * @param kafkaTemplate The Kafka template used for sending messages.
	 */
    	public PremiumAdjustmentProducer(KafkaTemplate<String, PremiumAdjustment> kafkaTemplate) {
        	this.kafkaTemplate = kafkaTemplate;
    	}

	/**
 	 * Sends a premium adjustment event to the "premium-changes" Kafka topic.
	 *
	 * @param adjustment The PremiumAdjustment object to be sent.
	 */
    	public void sendPremiumAdjustment(PremiumAdjustment adjustment) {
        	kafkaTemplate.send("premium-changes", adjustment);
    	}
}


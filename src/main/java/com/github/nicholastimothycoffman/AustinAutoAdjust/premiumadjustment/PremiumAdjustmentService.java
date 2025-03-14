package com.github.nicholastimothycoffman.AustinAutoAdjust.premiumadjustment.service;

import com.github.nicholastimothycoffman.AustinAutoAdjust.premiumadjustment.model.PremiumAdjustment;
import com.github.nicholastimothycoffman.AustinAutoAdjust.premiumadjustment.kafka.PremiumAdjustmentProducer;
import org.springframework.stereotype.Service;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

/**
 * Service class for handling premium adjustments based on traffic conditions.
 * This service calculates new premiums, stores them, and publishes adjustments to Kafka.
 */
@Service
public class PremiumAdjustmentService {

	/**
	 * Kafka producer for publishing premium adjustment events.
	 */
    	private final PremiumAdjustmentProducer kafkaProducer;
    	
	/**
	 * List to store premium adjustments in memory.
	 */
	private final List<PremiumAdjustment> adjustments = new ArrayList<>();

	/**
	 * Constructs a PremiumAdjustmentSerivce with the specified Kafka producer.
	 * 
	 * @param kafkaProducer The Kafka producer used to send premium adjustment events.
	 */
    	public PremiumAdjustmentService(PremiumAdjustmentProducer kafkaProducer) {
        	this.kafkaProducer = kafkaProducer;
    	}

	/**
	 * Calculates a new premium adjustment based on traffic speed and stores it.
	 *
	 * @param userId The ID of the user whose premium is being adjusted.
	 * @param currentPremium The user's current insurance premium.
	 * @param trafficSpeed The recorded traffic speed influencing the adjustment.
	 * @return The calculated PremiumAdjustment object.
	 */
    	public PremiumAdjustment calculateAdjustment(Long userId, double currentPremium, double trafficSpeed) {
        	double newPremium = (trafficSpeed < 30) ? currentPremium * 1.1 : currentPremium * 0.95;
        	String reason = (trafficSpeed < 30) ? "Increased congestion" : "Reduced traffic risk";

        	PremiumAdjustment adjustment = new PremiumAdjustment(userId, currentPremium, newPremium, reason, LocalDateTime.now());
        	adjustments.add(adjustment);

        	// Publish event to Kafka
        	kafkaProducer.sendPremiumAdjustment(adjustment);

        	return adjustment;
    	}

	/**
	 * Retrieves a list of past premium adjustments for a given user.
	 * 
	 * @param userId The ID of the user whose adjustments are to be retrieved.
	 * @return A list of PremiumAdjustment objects associated with the user.
	 */
    	public List<PremiumAdjustment> getAdjustmentsForUser(Long userId) {
        	return adjustments.stream().filter(adj -> adj.getUserId().equals(userId)).toList();
    	}
}


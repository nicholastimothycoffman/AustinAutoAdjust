package com.github.nicholastimothycoffman.AustinAutoAdjust.premiumadjustment.service;

import com.github.nicholastimothycoffman.AustinAutoAdjust.premiumadjustment.model.PremiumAdjustment;
import com.github.nicholastimothycoffman.AustinAutoAdjust.premiumadjustment.kafka.PremiumAdjustmentProducer;
import org.springframework.stereotype.Service;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Service
public class PremiumAdjustmentService {

    	private final PremiumAdjustmentProducer kafkaProducer;
    	private final List<PremiumAdjustment> adjustments = new ArrayList<>();

    	public PremiumAdjustmentService(PremiumAdjustmentProducer kafkaProducer) {
        	this.kafkaProducer = kafkaProducer;
    	}

    	public PremiumAdjustment calculateAdjustment(Long userId, double currentPremium, double trafficSpeed) {
        	double newPremium = (trafficSpeed < 30) ? currentPremium * 1.1 : currentPremium * 0.95;
        	String reason = (trafficSpeed < 30) ? "Increased congestion" : "Reduced traffic risk";

        	PremiumAdjustment adjustment = new PremiumAdjustment(userId, currentPremium, newPremium, reason, LocalDateTime.now());
        	adjustments.add(adjustment);

        	// Publish event to Kafka
        	kafkaProducer.sendPremiumAdjustment(adjustment);

        	return adjustment;
    	}

    	public List<PremiumAdjustment> getAdjustmentsForUser(Long userId) {
        	return adjustments.stream().filter(adj -> adj.getUserId().equals(userId)).toList();
    	}
}


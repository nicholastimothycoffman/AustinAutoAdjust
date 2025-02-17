package com.github.nicholastimothycoffman.AustinAutoAdjust.premiumadjustment.kafka;

import com.github.nicholastimothycoffman.AustinAutoAdjust.premiumadjustment.model.PremiumAdjustment;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class PremiumAdjustmentProducer {

    	private final KafkaTemplate<String, PremiumAdjustment> kafkaTemplate;

    	public PremiumAdjustmentProducer(KafkaTemplate<String, PremiumAdjustment> kafkaTemplate) {
        	this.kafkaTemplate = kafkaTemplate;
    	}

    	public void sendPremiumAdjustment(PremiumAdjustment adjustment) {
        	kafkaTemplate.send("premium-changes", adjustment);
    	}
}


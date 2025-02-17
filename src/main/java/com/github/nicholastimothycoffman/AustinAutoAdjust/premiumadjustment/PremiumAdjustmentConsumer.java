package com.github.nicholastimothycoffman.AustinAutoAdjust.premiumadjustment.kafka;

import com.github.nicholastimothycoffman.AustinAutoAdjust.premiumadjustment.model.PremiumAdjustment;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class PremiumAdjustmentConsumer {

    	@KafkaListener(topics = "premium-changes", groupId = "premium-group")
    	public void listenPremiumChanges(PremiumAdjustment adjustment) {
        	System.out.println("Received Premium Adjustment: " + adjustment);
    	}
}


package com.github.nicholastimothycoffman.AustinAutoAdjust.premiumadjustment.model;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "premium_adjustments")
public class PremiumAdjustment {

	@Id
    	@GeneratedValue(strategy = GenerationType.IDENTITY)
    	private Long adjustmentId;
	private Long userId;
    	private double oldPremium;
    	private double newPremium;
    	private String reason;
    	private LocalDateTime timestamp;

    	public PremiumAdjustment(Long userId, double oldPremium, double newPremium, String reason, LocalDateTime timestamp) {
        	this.userId = userId;
        	this.oldPremium = oldPremium;
        	this.newPremium = newPremium;
        	this.reason = reason;
        	this.timestamp = timestamp;
    	}

	public PremiumAdjustment() {}

	public Long getAdjustmentId() { return adjustmentId; }
    	public void setAdjustmentId(Long adjustmentId) { this.adjustmentId = adjustmentId; }

    	public Long getUserId() { return userId; }
    	public void setUserId(Long userId) { this.userId = userId; }

    	public double getOldPremium() { return oldPremium; }
    	public void setOldPremium(double oldPremium) { this.oldPremium = oldPremium; }

    	public double getNewPremium() { return newPremium; }
    	public void setNewPremium(double newPremium) { this.newPremium = newPremium; }

    	public String getReason() { return reason; }
    	public void setReason(String reason) { this.reason = reason; }

    	public LocalDateTime getTimestamp() { return timestamp; }
    	public void setTimestamp(LocalDateTime timestamp) { this.timestamp = timestamp; }
}


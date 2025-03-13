package com.github.nicholastimothycoffman.AustinAutoAdjust.premiumadjustment.model;

import jakarta.persistence.*;
import java.time.LocalDateTime;

/**
 * Entity class representing a premium adjustment for a user.
 * This class is mapped to the "premium_adjustments" table in the database.
 * It stores information about premium changes, including old and new premium values,
 * the reason for adjustment, and a timestamp of when the adjustment was made.
 */
@Entity
@Table(name = "premium_adjustments")
public class PremiumAdjustment {

	/** Unique identifier for the premium adjustment. */
	@Id
    	@GeneratedValue(strategy = GenerationType.IDENTITY)
    	private Long adjustmentId;

	/** User ID associated with the premium adjustment. */
	private Long userId;

	/** Previous premium amount before adjustment. */
    	private double oldPremium;

	/** New premium amount after adjustment. */
    	private double newPremium;

	/** Reason for the premium adjustment. */
    	private String reason;

	/** Timestamp indicating when the adjustment was made. */
    	private LocalDateTime timestamp;

	/**
	 * Constructor to create a new PremiumAdjustment instance.
	 *
	 * @param userId The user ID for whom the adjustment is made.
	 * @param oldPremium The original premium amount.
	 * @param newPremium The adjusted premium amount.
	 * @param reason The reason for the premium adjustment.
	 * @param timestamp The timestamp when the adjustment was applied.
	 */
    	public PremiumAdjustment(Long userId, double oldPremium, double newPremium, String reason, LocalDateTime timestamp) {
        	this.userId = userId;
        	this.oldPremium = oldPremium;
        	this.newPremium = newPremium;
        	this.reason = reason;
        	this.timestamp = timestamp;
    	}

	/**
	 * Default constructor for JPA.
	 */
	public PremiumAdjustment() {}

	/**
	 * Gets the unique identifier for this premium adjustment.
	 * @return The adjustment ID.
	 */
	public Long getAdjustmentId() { return adjustmentId; }

	/**
	 * Sets the unique identifier for this premium adjustment.
	 * 
	 * @param adjustmentID The adjustment ID to set.
	 */
    	public void setAdjustmentId(Long adjustmentId) { this.adjustmentId = adjustmentId; }

	/**
	 * Gets the user ID associated with this premium adjustment.
	 *
	 * @return The user ID.
	 */
    	public Long getUserId() { return userId; }

	/**
	 * Sets the user ID associated with this premium adjustment.
	 *
	 * @param userID The user ID to set.
	 */
    	public void setUserId(Long userId) { this.userId = userId; }

	/**
	 * Gets the previous premium amount before adjustment.
	 * 
	 * @return The old premium amount.
	 */
    	public double getOldPremium() { return oldPremium; }

	/**
	 * Sets the previous premium amount before adjustment.
	 *
	 * @param oldPremium The old premium amount to set.
	 */
    	public void setOldPremium(double oldPremium) { this.oldPremium = oldPremium; }

	/**
	 * Gets the new premium amount after adjustment.
	 *
	 * @return The new premium amount.
	 */
    	public double getNewPremium() { return newPremium; }

	/**
	 * Sets the new premium amount after adjustment.
	 *
	 * @param newPremium The new premium amount to set.
	 */
    	public void setNewPremium(double newPremium) { this.newPremium = newPremium; }

	/**
	 * Gets the reason for the premium adjustment.
	 *
	 * @return The reason for adjustment.
	 */
    	public String getReason() { return reason; }

	/**
	 * Sets the reason for the premium adjustment.
	 *
	 * @param reason The reason for adjustment to set.
	 */
    	public void setReason(String reason) { this.reason = reason; }

	/**
	 * Gets the timestamp indicating when the adjustment was made.
	 *
	 * @return The timestamp of the adjustment.
	 */
    	public LocalDateTime getTimestamp() { return timestamp; }

	/**
	 * Sets the timestamp indicating when the adjustment was made.
	 *
	 * @param timestamp The timestamp to set.
	 */
    	public void setTimestamp(LocalDateTime timestamp) { this.timestamp = timestamp; }
}


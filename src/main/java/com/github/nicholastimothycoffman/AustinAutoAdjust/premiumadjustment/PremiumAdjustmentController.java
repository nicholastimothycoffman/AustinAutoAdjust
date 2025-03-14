package com.github.nicholastimothycoffman.AustinAutoAdjust.premiumadjustment.controller;

import com.github.nicholastimothycoffman.AustinAutoAdjust.premiumadjustment.model.PremiumAdjustment;
import com.github.nicholastimothycoffman.AustinAutoAdjust.premiumadjustment.service.PremiumAdjustmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

/**
 * REST controller for handling premium adjustments based on traffic data.
 * This controller provides endpoints for calculating a new premium and
 * retrieving a user's past premium adjustments.
 */
@RestController
@RequestMapping("/adjustments")
public class PremiumAdjustmentController {

	/** Service for handling premium adjustment calculations and retrievals. */
    	@Autowired
    	private PremiumAdjustmentService service;

	/**
	 * Calculates a new premium adjustment based on the provided traffic data.
	 *
	 * @param request A JSON request body containing:
	 *	- "userId" (Long): The user's ID.
	 *	- "currentPremium" (Double): The current insurance premium.
	 *	- "trafficSpeed" (Double): The recorded traffic speed affecting the premium.
	 * @return The calculated {@link PremiumAdjustment} wrapped in a ResponseEntity.
	 */
    	@PostMapping("/calculate")
    	public ResponseEntity<PremiumAdjustment> calculatePremium(@RequestBody Map<String, Object> request) {
        	Long userId = ((Number) request.get("userId")).longValue();
        	Double currentPremium = ((Number) request.get("currentPremium")).doubleValue();
        	Double trafficSpeed = ((Number) request.get("trafficSpeed")).doubleValue();

        	PremiumAdjustment adjustment = service.calculateAdjustment(userId, currentPremium, trafficSpeed);
        	return ResponseEntity.ok(adjustment);
    	}

	/**
	 * Retrieves all premium adjustments for a given user.
	 *
	 * @param userId The ID of the user whose adjustments should be retrieved.
	 * @return A list of {@link PremiumAdjustment} records wrapped in a ResponseEntity.
	 */
    	@GetMapping("/{userId}")
    	public ResponseEntity<List<PremiumAdjustment>> getUserAdjustments(@PathVariable Long userId) {
        	return ResponseEntity.ok(service.getAdjustmentsForUser(userId));
    	}
}


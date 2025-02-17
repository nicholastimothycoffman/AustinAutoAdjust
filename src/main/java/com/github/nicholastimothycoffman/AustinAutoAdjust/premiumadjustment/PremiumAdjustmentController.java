package com.github.nicholastimothycoffman.AustinAutoAdjust.premiumadjustment.controller;

import com.github.nicholastimothycoffman.AustinAutoAdjust.premiumadjustment.model.PremiumAdjustment;
import com.github.nicholastimothycoffman.AustinAutoAdjust.premiumadjustment.service.PremiumAdjustmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/adjustments")
public class PremiumAdjustmentController {

    	@Autowired
    	private PremiumAdjustmentService service;

    	@PostMapping("/calculate")
    	public ResponseEntity<PremiumAdjustment> calculatePremium(@RequestBody Map<String, Object> request) {
        	Long userId = ((Number) request.get("userId")).longValue();
        	Double currentPremium = ((Number) request.get("currentPremium")).doubleValue();
        	Double trafficSpeed = ((Number) request.get("trafficSpeed")).doubleValue();

        	PremiumAdjustment adjustment = service.calculateAdjustment(userId, currentPremium, trafficSpeed);
        	return ResponseEntity.ok(adjustment);
    	}

    	@GetMapping("/{userId}")
    	public ResponseEntity<List<PremiumAdjustment>> getUserAdjustments(@PathVariable Long userId) {
        	return ResponseEntity.ok(service.getAdjustmentsForUser(userId));
    	}
}


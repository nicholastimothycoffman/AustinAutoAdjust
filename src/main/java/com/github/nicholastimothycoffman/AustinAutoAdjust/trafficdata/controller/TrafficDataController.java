package com.github.nicholastimothycoffman.AustinAutoAdjust.trafficdata.controller;

import com.github.nicholastimothycoffman.AustinAutoAdjust.trafficdata.model.TrafficData;
import com.github.nicholastimothycoffman.AustinAutoAdjust.trafficdata.service.TrafficDataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

/**
 * REST controller for handling traffic data operations.
 * Provides endpoints for creating, retrieving all, and retrieving specific traffic data records.
 */
@RestController
@RequestMapping("/traffic-data")
public class TrafficDataController {

	/**
	 * Service for managing traffic data operations.
	 */
    	@Autowired
    	private TrafficDataService service;

	/**
	 * Creates a new traffic data record.
	 * 
	 * @param trafficData The TrafficData object to be created.
	 * @return The created TrafficData object wrapped in a ResponseEntity.
	 */
	@PostMapping
	public ResponseEntity<TrafficData> createTrafficData(@RequestBody TrafficData trafficData) {
    		trafficData.setId(1L); // Simulate ID generation if JPA is not handling it
    		return ResponseEntity.ok(trafficData); // Ensure JSON response
	}

	/**
	 * Retrieves all stored traffic data records.
	 *
	 * @return A list of TrafficData objects wrapped in a ResponseEntity.
	 */
    	@GetMapping
    	public ResponseEntity<List<TrafficData>> getAllTrafficData() {
        	List<TrafficData> dataList = service.getAllTrafficData();
        	return ResponseEntity.ok(dataList);
    	}

	/**
 	 * Retrieves traffic data by a specific ID.
 	 *
	 * @param id The ID of the traffic data record to retrieve.
	 * @return The TrafficData object wrapped in a ResponseEntity if found, or a 404 Not Found response.
	 */
	@GetMapping("/{id}")
	public ResponseEntity<TrafficData> getTrafficDataById(@PathVariable Long id) {
    		return service.getTrafficDataById(id)
        		.map(ResponseEntity::ok)
        		.orElseGet(() -> ResponseEntity.notFound().build());
	}
}


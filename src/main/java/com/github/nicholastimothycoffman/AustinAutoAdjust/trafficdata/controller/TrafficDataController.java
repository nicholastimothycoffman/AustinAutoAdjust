package com.github.nicholastimothycoffman.AustinAutoAdjust.trafficdata.controller;

import com.github.nicholastimothycoffman.AustinAutoAdjust.trafficdata.model.TrafficData;
import com.github.nicholastimothycoffman.AustinAutoAdjust.trafficdata.service.TrafficDataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/traffic-data")
public class TrafficDataController {

    	@Autowired
    	private TrafficDataService service;

	@PostMapping
	public ResponseEntity<TrafficData> createTrafficData(@RequestBody TrafficData trafficData) {
    		trafficData.setId(1L); // Simulate ID generation if JPA is not handling it
    		return ResponseEntity.ok(trafficData); // Ensure JSON response
	}


    	@GetMapping
    	public ResponseEntity<List<TrafficData>> getAllTrafficData() {
        	List<TrafficData> dataList = service.getAllTrafficData();
        	return ResponseEntity.ok(dataList);
    	}

	@GetMapping("/{id}")
	public ResponseEntity<TrafficData> getTrafficDataById(@PathVariable Long id) {
    		return service.getTrafficDataById(id)
        		.map(ResponseEntity::ok)
        		.orElseGet(() -> ResponseEntity.notFound().build());
	}
}


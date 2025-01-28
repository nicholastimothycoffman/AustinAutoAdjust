package github.com.nicholastimothycoffman.AustinAutoAdjust.trafficdata.controller;

import github.com.nicholastimothycoffman.AustinAutoAdjust.trafficdata.model.TrafficData;
import github.com.nicholastimothycoffman.AustinAutoAdjust.trafficdata.service.TrafficDataService;
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
        	TrafficData savedData = service.saveTrafficData(trafficData);
        	return ResponseEntity.ok(savedData);
    	}

    	@GetMapping
    	public ResponseEntity<List<TrafficData>> getAllTrafficData() {
        	List<TrafficData> dataList = service.getAllTrafficData();
        	return ResponseEntity.ok(dataList);
    	}

    	@GetMapping("/{id}")
    	public ResponseEntity<Optional<TrafficData>> getTrafficDataById(@PathVariable Long id) {
        	Optional<TrafficData> data = service.getTrafficDataById(id);
        	return data.isPresent() ? ResponseEntity.ok(data) : ResponseEntity.notFound().build();
    	}
}


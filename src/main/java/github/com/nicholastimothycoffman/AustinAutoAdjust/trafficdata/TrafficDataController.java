// Exposes RESTful endpoints for clients to interact with the traffic data system
// (e.g., adding new data or retrieving existing data).
//
// The `@RestController` annotation marks this class as a REST controller that can
// handle HTTP requests and return responses in JSON format.
//
// The `@RequestMapping("/api/traffic")` annotation specifies the base URL path for
// this controller's endpoints (e.g., `http://localhost:8080/api/traffic)`.
//
// `@PostMapping` handles HTTP `POST` requests to add traffic data.
//
// `@GetMapping` handles HTTP `GET` requests to retrieve all traffic data.

package github.com.nicholastimothycoffman.AustinAutoAdjust.trafficdata;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.ResponseEntity;
import org.springframework.web.server.ResponseStatusException;
import java.util.List;

@RestController
@RequestMapping("/api/traffic")
public class TrafficDataController {
    	@Autowired
    	private TrafficDataService service;

    	@PostMapping
    	public ResponseEntity<TrafficData> addTrafficData(@RequestBody TrafficData trafficData) {
        	try {
			TrafficData = savedData = service.saveTrafficData(trafficData);
			return ResponseEntity.ok(savedData);
		} catch (Exception e) {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Failed to save traffic data", e);
		}		
	}

    	@GetMapping
    	public ResponseEntity<List<TrafficData>> getAllTrafficData() {
		try {
			List<TrafficData> data = service.getAllTrafficData();
			return ResponseEntity.ok(data);
		} catch {
			throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, "Failed to retrieve data", e);
		}
    	}

	@ExceptionHandler(Exception.class)
	public ResponseEntity<String> handleException(Exception e) {
    		return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
	}	

}


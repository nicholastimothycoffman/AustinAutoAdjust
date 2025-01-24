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

import java.util.List;

@RestController
@RequestMapping("/api/traffic")
public class TrafficDataController {
    @Autowired
    private TrafficDataService service;

    // Endpoint to add new traffic data
    @PostMapping
    public TrafficData addTrafficData(@RequestBody TrafficData trafficData) {
        return service.saveTrafficData(trafficData);
    }

    // Endpoint to retrieve all traffic data
    @GetMapping
    public List<TrafficData> getAllTrafficData() {
        return service.getAllTrafficData();
    }
}


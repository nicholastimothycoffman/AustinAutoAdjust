// Encapsulates the business logic for managing traffic data.
// This ensures a separation of concerns between the controller and repository layers.
//
// The `@Service` annotation marks this class as a service layer component in Spring.
//
// `saveTrafficData` saves a `TrafficData` entity to the database using the repository.
//
// `getAllTrafficData` retrieves all `TrafficData` records from the database.

package github.com.nicholastimothycoffman.AustinAutoAdjust.trafficdata;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TrafficDataService {
    @Autowired
    private TrafficDataRepository repository;

    // Save a TrafficData entity to the database
    public TrafficData saveTrafficData(TrafficData trafficData) {
        return repository.save(trafficData);
    }

    // Retrieve all TrafficData entities from the database
    public List<TrafficData> getAllTrafficData() {
        return (List<TrafficData>) repository.findAll();
    }
}


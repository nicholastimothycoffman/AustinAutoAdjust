package github.com.nicholastimothycoffman.AustinAutoAdjust.trafficdata;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.list.Optional;
import java.util.List;

@Service
public class TrafficDataService {
    	@Autowired
    	private TrafficDataRepository repository;

    	// Save a TrafficData entity to the database
    	public TrafficData saveTrafficData(TrafficData trafficData) {
		if (trafficData == null || trafficData.getLocation() == null || trafficData.getSpeed() == null || trafficData.getTrafficVolume() == null) {
            		throw new IllegalArgumentException("Invalid traffic data provided");
        	}
        	try {
            		return repository.save(trafficData);
        	} catch (Exception e) {
            		throw new RuntimeException("Database operation failed", e);
        	}
    	}

    	// Retrieve all TrafficData entities from the database
    	public List<TrafficData> getAllTrafficData() {
		try {
			return (List<TrafficData>) repository.findAll();
    		} catch (Exception e) {
			throw new RuntimeException("Database operation failed", e);
		}
	}

	// Method to get traffic factor based on user's ID
	public Double getTrafficFactor(Long userId) {
		List<TrafficData> recentData = getRecentTrafficData();
    		return calculateTrafficFactor(recentData);
	}

	// Private method to fetch recent traffic data
	private List<TrafficData> getRecentTrafficData() {
		// For simplicity, assuming fetching all data, ideally filter by some
		// criteria like recent timestamps
		return (List<TrafficData>) repository.findAll();
	}

	// Private method to calculate traffic factor based on traffic data
    	private Double calculateTrafficFactor(List<TrafficData> trafficData) {
        	if (trafficData.isEmpty()) {
            		return 1.0; // Assuming normal traffic conditions if no data
        	}
        
		double averageSpeed = trafficData.stream()
                	                         .mapToDouble(TrafficData::getSpeed)
                	                         .average()
                	                         .orElse(60.0); // Default to normal speed if no data

        	double normalSpeed = 60.0; // Define what you consider 'normal' speed
        	return normalSpeed / averageSpeed; // Traffic factor calculation
    	}

}


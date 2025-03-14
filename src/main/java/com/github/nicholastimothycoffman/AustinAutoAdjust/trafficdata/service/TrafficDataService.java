package com.github.nicholastimothycoffman.AustinAutoAdjust.trafficdata.service;

import com.github.nicholastimothycoffman.AustinAutoAdjust.trafficdata.model.TrafficData;
import com.github.nicholastimothycoffman.AustinAutoAdjust.trafficdata.repository.TrafficDataRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

/**
 * Service class for handling operations related to TrafficData.
 * Provides methods for saving, retrieving all, and retrieving specific traffic data records.
 */
@Service
public class TrafficDataService {

	/**
	 * Repository for managing TrafficData persistence.
	 */
    	@Autowired
    	private TrafficDataRepository repository;

	/**
	 * Saves a TrafficData entity to the database.
	 * 
	 * @param trafficData The TrafficData object to be saved.
	 * @return The saved TrafficData object.
	 */
    	public TrafficData saveTrafficData(TrafficData trafficData) {
        	return repository.save(trafficData);
    	}

	/**
	 * Retrives all TrafficData records from the database.
	 * 
	 * @return A list of all TrafficData objects.
	 */
    	public List<TrafficData> getAllTrafficData() {
        	return repository.findAll();
    	}

	/**
	 * Retrieves a TrafficData record by its unique ID.
	 * 
	 * @param id The ID of the TrafficData record to retrieve.
	 * @return An Optional containing the TrafficData object if found, otherwise empty.
	 */
    	public Optional<TrafficData> getTrafficDataById(Long id) {
        	return repository.findById(id);
    	}
}


package com.github.nicholastimothycoffman.AustinAutoAdjust.trafficdata.service;

import com.github.nicholastimothycoffman.AustinAutoAdjust.trafficdata.model.TrafficData;
import com.github.nicholastimothycoffman.AustinAutoAdjust.trafficdata.repository.TrafficDataRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class TrafficDataService {

    	@Autowired
    	private TrafficDataRepository repository;

    	public TrafficData saveTrafficData(TrafficData trafficData) {
        	return repository.save(trafficData);
    	}

    	public List<TrafficData> getAllTrafficData() {
        	return repository.findAll();
    	}

    	public Optional<TrafficData> getTrafficDataById(Long id) {
        	return repository.findById(id);
    	}
}


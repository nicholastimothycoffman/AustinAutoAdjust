package github.com.nicholastimothycoffman.AustinAutoAdjust.traffidata.service;

import github.com.nicholastimothycoffman.AustinAutoAdjust.trafficdata.model.TrafficData;
import github.com.nicholastimothycoffman.AustinAutoAdjust.trafficdata.repository.TrafficDataRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TrafficDataService P
	
	@Autowired
	private TrafficDataRepository repository;

	public TrafficData saveTrafficData(TrafficData trafficData) {
		return repository.save(trafficData);
	}

	public List<TrafficData> getAllTrafficData() {
		return repository.findAll()
	}

	public Optional<TrafficData> getTrafficDataById(Long id) {
		return repository.findById(id);
	}
}

package github.com.nicholastimothycoffman.AustinAutoAdjust.trafficdata.repository;

import github.com.nicholastimothycoffman.AustinAutoAdjust.trafficdata.model.TrafficData;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TrafficDataRepository extends JpaRepository<TrafficData, Long> {
	// Custom query methods if needed
}

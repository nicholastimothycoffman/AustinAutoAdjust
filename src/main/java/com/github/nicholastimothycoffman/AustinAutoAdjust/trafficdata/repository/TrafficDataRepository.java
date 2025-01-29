package com.github.nicholastimothycoffman.AustinAutoAdjust.trafficdata.repository;

import com.github.nicholastimothycoffman.AustinAutoAdjust.trafficdata.model.TrafficData;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TrafficDataRepository extends JpaRepository<TrafficData, Long> {
	// Custom query methods if needed
}

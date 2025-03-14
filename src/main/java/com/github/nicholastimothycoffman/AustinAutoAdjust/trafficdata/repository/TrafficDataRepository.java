package com.github.nicholastimothycoffman.AustinAutoAdjust.trafficdata.repository;

import com.github.nicholastimothycoffman.AustinAutoAdjust.trafficdata.model.TrafficData;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Repository interface for managing TrafficData entities.
 * Extends JpaRepository to provide CRUD operations for TrafficData objects.
 */
@Repository
public interface TrafficDataRepository extends JpaRepository<TrafficData, Long> {
	// Custom query methods if needed
}

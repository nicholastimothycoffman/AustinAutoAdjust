package com.github.nicholastimothycoffman.AustinAutoAdjust.premiumadjustment.repository;

import com.github.nicholastimothycoffman.AustinAutoAdjust.premiumadjustment.model.PremiumAdjustment;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

/**
 * Repository interface for managing PremiumAdjustment entities.
 * Extends JpaRepository to provide basic CRUD operations for PremiumAdjustment objects.
 */
public interface PremiumAdjustmentRepository extends JpaRepository<PremiumAdjustment, Long> {
    	
	/**
	 * Retrieves a list of PremiumAdjustment records associated with a specific user ID.
	 *
	 * @param userId The ID of the user whose premium adjustments are to be retrieved.
	 * @return A list of PremiumAdjustment objects belonging to the specified user.
	 */
	List<PremiumAdjustment> findByUserId(Long userId);
}


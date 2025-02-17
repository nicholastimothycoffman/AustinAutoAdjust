package com.github.nicholastimothycoffman.AustinAutoAdjust.premiumadjustment.repository;

import com.github.nicholastimothycoffman.AustinAutoAdjust.premiumadjustment.model.PremiumAdjustment;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface PremiumAdjustmentRepository extends JpaRepository<PremiumAdjustment, Long> {
    	List<PremiumAdjustment> findByUserId(Long userId);
}


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;
import java.util.Date;

@Service
public class PremiumAdjustmentService {
	@Autowired
    	private PremiumAdjustmentRepository repository;

	@Autowired
	private TrafficDataService trafficDataService;	// Dependency to get traffic data

	public PremiumAdjustment calculateNewPremium(Long userId, Double currentPremium, Double riskFactor) {
		// Validate inputs
        	Assert.notNull(userId, "User ID cannot be null");
        	Assert.isTrue(currentPremium > 0, "Current premium must be greater than zero");
        	Assert.isTrue(riskFactor >= 0, "Risk factor must not be negative");

        	// Calculate the traffic factor using the TrafficDataService
        	Double trafficFactor;
        	try {
            		trafficFactor = trafficDataService.getTrafficFactor(userId);
        	} catch (Exception e) {
            		// Handle potential exceptions from the TrafficDataService (e.g., no data available)
            		throw new IllegalStateException("Failed to retrieve traffic factor for user ID: " + userId, e);
        	}

        	// Compute the new premium based on risk and traffic factors
        	Double newPremium = currentPremium * (1 + trafficFactor + riskFactor); 
        	String reason = "Adjustment based on traffic conditions and risk factors.";

        	// Create and save the new PremiumAdjustment
        	try {
            		PremiumAdjustment adjustment = new PremiumAdjustment(userId, currentPremium, newPremium, reason, new Date());
            		return repository.save(adjustment);
        	} catch (Exception e) {
            		// Handle exceptions from the repository (e.g., database errors)
            		throw new RuntimeException("Failed to save the premium adjustment", e);
        	}
    	}
}


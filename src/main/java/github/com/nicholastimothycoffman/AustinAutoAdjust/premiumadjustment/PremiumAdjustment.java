import javax.persistence.*;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import java.util.Date;

@Entity
public class PremiumAdjustment {
	@Id
    	@GeneratedValue(strategy = GenerationType.AUTO)
    	private Long adjustmentId;
    
	@NotNull
	private Long userId;
    
	@NotNull
	@Min(0)
	private Double oldPremium;
    
	@NotNull
	@Min(0)
	private Double newPremium;
    
	@NotNull
	private String reason;
    
	@NotNull
	private Date timestamp;

    	// Constructors, getters, and setters
    	public PremiumAdjustment() {}

    	public PremiumAdjustment(Long userId, Double oldPremium, Double newPremium, String reason, Date timestamp) {
        	this.userId = userId;
        	this.oldPremium = oldPremium;
        	this.newPremium = newPremium;
        	this.reason = reason;
        	this.timestamp = timestamp;
    	}

    	// Getters and setters
}


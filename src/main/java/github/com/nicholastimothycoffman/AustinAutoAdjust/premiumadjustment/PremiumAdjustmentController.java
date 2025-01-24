import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.http.HttpStatus;


@RestController
@RequestMapping("/adjustments")
public class PremiumAdjustmentController {
    	@Autowired
    	private PremiumAdjustmentService service;

    	@PostMapping("/calculate")
	public ResponseEntity<PremiumAdjustment> calculateAdjustment(@RequestBody PremiumAdjustment adjustment) {
        	try {
            		PremiumAdjustment savedAdjustment = service.calculateNewPremium(adjustment.getUserId(), adjustment.getOldPremium(), adjustment.getNewPremium());
            		return ResponseEntity.ok(savedAdjustment);
        	} catch (IllegalArgumentException e) {
            		throw new ResponseStatusException(HttpStatus.BAD_REQUEST, e.getMessage());
        	} catch (Exception e) {
            		return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
        	}
	}
	
	@ExceptionHandler({ IllegalArgumentException.class })
    	@ResponseStatus(HttpStatus.BAD_REQUEST)
    	public ResponseEntity<String> handleIllegalArgumentException(IllegalArgumentException e) {
        	return ResponseEntity.badRequest().body(e.getMessage());
    	}
}

class AdjustmentRequest {
    	private Long userId;
    	private Double currentPremium;
    	private Double trafficFactor;

    	// Constructors, getters, and setters
}


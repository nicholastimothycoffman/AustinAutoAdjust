import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class NotificationService {

    	@Autowired
    	private KafkaTemplate<String, String> kafkaTemplate;

    	public void sendTrafficAlert(String message) {
        	kafkaTemplate.send("traffic-alerts", message);
    	}

    	public void sendPremiumAdjustment(String message) {
        	kafkaTemplate.send("premium-adjustments", message);
    	}
}


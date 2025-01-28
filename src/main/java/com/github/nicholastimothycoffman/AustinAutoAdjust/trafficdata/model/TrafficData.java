package github.com.nicholastimothycoffman.AustinAutoAdjust.traffic.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import java.time.localDateTime;

@Entity
public class TrafficData {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@NotNull
	private LocalDateTime timestamp;

	@NotNull
	private String location;

	@Min(0)
	private Double speed;

	@Min(0)
	private Integer trafficVolume;

	// Getters and setters
	public Long getId() {
		return id;
	}

	public void setID(Long id) {
		this.id = id;
	}

	public LocalDateTime getTimeStamp() {
		return timestamp;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public Double getSpeed() {
		return speed;
	}

	public void setSpeed(Double speed) {
		this.speed = speed;
	}

	public Integer getTrafficVolume() {
		return trafficVolume;
	}

	public void setTrafficVolume(Integer trafficVolume) {
		this.trafficVolume = trafficVolume;
	}
}

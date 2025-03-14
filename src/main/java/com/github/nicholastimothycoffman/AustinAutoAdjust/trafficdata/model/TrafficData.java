package com.github.nicholastimothycoffman.AustinAutoAdjust.trafficdata.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import java.time.LocalDateTime;

/**
 * Entity class representing traffic data records.
 * This class is mapped to a database table and stores information
 * about traffic speed, volume, and location at a given timestamp.
 */
@Entity
public class TrafficData {

	/**
	 * Unique identifier for the traffic data record.
	 */	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	/**
	 * Timestamp representing when the traffic data was recorded.
	 * This field cannot be null.
 	 */
	@NotNull
	private LocalDateTime timestamp;

	/**
	 * Location where the traffic data was recorded.
	 * This field cannot be null.
	 */
	@NotNull
	private String location;

	/**
	 * Speed of traffic at the recorded location (in km/h or mph).
	 * Must be a non-negative value.
	 */
	@Min(0)
	private Double speed;

	/**
	 * The volume of traffic at the recorded location (number of vehicles).
	 * Must be a non-negative value.
	 */
	@Min(0)
	private Integer trafficVolume;

	/**
	 * Retrieves the ID of the traffic data record.
	 * @return The unique identifier of this record.
	 */
	public Long getId() {
		return id;
	}

	/**
	 * Sets the ID of the traffic data record.
	 * @param id The unique identifier to set.
	 */
	public void setId(Long id) {
		this.id = id;
	}

	/**
	 * Retrives the timestamp of when the traffic data was recorded.
	 * @return The timestamp of the record.
	 */
	public LocalDateTime getTimestamp() {
		return timestamp;
	}

	/**
	 * Sets the timestamp for the traffic data record.
	 * @param timestamp The timestamp to set.
	 */
	public void setTimestamp(LocalDateTime timestamp) {
		this.timestamp = timestamp;
	}

	/**
	 * Retrieves the location of the recorded traffic data.
	 * @return The location where traffic data was collected.
	 */
	public String getLocation() {
		return location;
	}

	/**
	 * Sets the location of the recorded traffic data.
	 * @param location The location to set.
	 */
	public void setLocation(String location) {
		this.location = location;
	}

	/**
	 * Retrieves the recorded speed of traffic.
	 * @return The speed of traffic in the given location.
	 */
	public Double getSpeed() {
		return speed;
	}

	/**
	 * Sets the recorded speed of traffic.
	 * @param speed The speed value to set.
	 */
	public void setSpeed(Double speed) {
		this.speed = speed;
	}

	/**
	 * Retrieves the recorded traffic volume.
	 * @return The number of vehicles recorded at the location.
	 */
	public Integer getTrafficVolume() {
		return trafficVolume;
	}

	/**
	 * Sets the recorded traffic volume.
	 * @param trafficVolume The traffic volume value to set.
	 */
	public void setTrafficVolume(Integer trafficVolume) {
		this.trafficVolume = trafficVolume;
	}
}


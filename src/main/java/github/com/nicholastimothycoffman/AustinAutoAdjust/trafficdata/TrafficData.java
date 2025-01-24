package github.com.nicholastimothycoffman.AustinAutoAdjust.trafficdata;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.time.LocalDateTime;

@Entity
public class TrafficData {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private LocalDateTime timestamp;
    private String location;
    private Double speed;
    private Integer trafficVolume;

    // Default Constructor
    public TrafficData() {}

    // Constructor
    public TrafficData(LocalDateTime timestamp, String location, Double speed, Integer trafficVolume) {
        this.timestamp = timestamp;
        this.location = location;
        this.speed = speed;
        this.trafficVolume = trafficVolume;
    }

    // Getters and Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalDateTime getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(LocalDateTime timestamp) {
        this.timestamp = timestamp;
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


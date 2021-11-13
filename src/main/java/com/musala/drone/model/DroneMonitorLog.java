package com.musala.drone.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.Date;
import java.util.Objects;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table
@JsonIgnoreProperties({"hibernateLazyInitializer"})
public class DroneMonitorLog {
    @Id
    @GeneratedValue
    private int id;

    @JsonManagedReference("drone_serial")
    @ManyToOne(cascade= { CascadeType.ALL})
    @JoinColumn(name="drone_name")
    @NotNull(message = "Drone mandatory")
    private Drone drone;

    @Column(name = "battery_capacity")
    @NotNull(message = "Battery capacity mandatory")
    private double batteryCapacity;

    @Column(name="timestamp", columnDefinition="TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
    private Date timestamp;

    @Override
    public int hashCode() {
        return Objects.hash(this.id, this.drone, this.timestamp);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof DroneMonitorLog)) return false;
        DroneMonitorLog that = (DroneMonitorLog) o;
        return id == that.id && Double.compare(that.batteryCapacity, batteryCapacity) == 0 && Objects.equals(drone, that.drone) && Objects.equals(timestamp, that.timestamp);
    }
}

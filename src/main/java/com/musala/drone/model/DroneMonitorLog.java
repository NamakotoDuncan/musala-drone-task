package com.musala.drone.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table
public class DroneMonitorLog {
    @Id
    @GeneratedValue
    private int id;

    @JsonBackReference
    @ManyToOne(cascade= { CascadeType.ALL})
    @JoinColumn(name="drone_name")
    @NotNull(message = "Drone mandatory")
    private Drone drone;

    @Column(name = "battery_capacity")
    @NotNull(message = "Battery capacity mandatory")
    private double batteryCapacity;

    @Column(name="timestamp", columnDefinition="TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
    private Date timestamp;

}

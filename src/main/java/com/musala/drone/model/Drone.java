package com.musala.drone.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Table;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table
public class Drone {
    private String serialNumber;
    private String model;
    static double weightLimit = 500;
    private double batteryCapacity;
    //    private String state;
    @Enumerated(EnumType.ORDINAL)
    private DroneState status;
}

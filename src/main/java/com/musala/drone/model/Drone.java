package com.musala.drone.model;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table
public class Drone implements Serializable {
    @Id
    @Column(name = "serial_number")
    private String serialNumber;
    private String model;
    static double weightLimit = 500;
    @Column(name = "battery_capacity")
    private double batteryCapacity;
    //    private String state;
    @Enumerated(EnumType.ORDINAL)
    private DroneState status;

    @JsonManagedReference
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "drone",
            cascade = {
                    CascadeType.MERGE,
                    CascadeType.PERSIST,
                    CascadeType.REMOVE
            })
    private List<DroneLoad> droneLoads;
}

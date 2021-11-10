package com.musala.drone.model;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.*;
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
    @NotBlank(message = "Serial Number mandatory")
    @Size(min = 1, message = "{validation.serialNumber.size.too_short}")
    @Size(max = 100, message = "{validation.serialNumber.size.too_long}")
    private String serialNumber;

    @Enumerated(EnumType.ORDINAL)
    private DroneModel model;

    /*
    * @Min(1)
  @Max(10)
    * */
    static double weightLimit = 500;

    @Column(name = "battery_capacity")
    @Min(0)
    @Max(100)
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

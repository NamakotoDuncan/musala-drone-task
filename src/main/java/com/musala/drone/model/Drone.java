package com.musala.drone.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.*;
import java.io.Serializable;
import java.util.List;
import java.util.Objects;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table
@JsonIgnoreProperties({"hibernateLazyInitializer"})
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
    public static double WEIGHT_LIMIT = 500;

    @Column(name = "battery_capacity")
    @Min(0)
    @Max(100)
    private double batteryCapacity;
    //    private String state;
    @Column(name = "status")
    @Enumerated(EnumType.ORDINAL)
    private DroneState status;

    @Column(name = "droneLoads")
    @JsonBackReference("droneLoads")
    @OneToMany(fetch = FetchType.EAGER, mappedBy = "drone",
            cascade = {
                    CascadeType.MERGE,
                    CascadeType.PERSIST,
                    CascadeType.REMOVE
            })
    private List<DroneLoad> droneLoads;

    @Override
    public int hashCode() {
        return Objects.hash(this.serialNumber, this.batteryCapacity, this.status);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Drone)) return false;
        Drone drone = (Drone) o;
        return Double.compare(drone.batteryCapacity, batteryCapacity) == 0 && Objects.equals(serialNumber, drone.serialNumber) && model == drone.model && status == drone.status && Objects.equals(droneLoads, drone.droneLoads);
    }
}

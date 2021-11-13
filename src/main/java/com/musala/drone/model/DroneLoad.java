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
import java.io.Serializable;
import java.util.Date;
import java.util.Objects;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table
@JsonIgnoreProperties({"hibernateLazyInitializer"})
public class DroneLoad implements Serializable {
    @Id
    @GeneratedValue
    private int id;

    @JsonBackReference("drone_name")
    @ManyToOne(cascade= { CascadeType.ALL})
    @JoinColumn(name="drone_name")
//    @NotBlank(message = "Drone mandatory")
    private Drone drone;

    @JsonManagedReference("medication_name")
    @ManyToOne(cascade= { CascadeType.ALL})
    @JoinColumn(name="medication_name")
//    @NotBlank(message = "Medication mandatory")
    private Medication medication;

    @Column(name="loadTime", columnDefinition="TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
    private Date loadTime;

    @Column(name="deliveryTime")
    private Date deliveryTime;

    @Override
    public int hashCode() {
        return Objects.hash(this.id, this.drone, this.medication);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof DroneLoad)) return false;
        DroneLoad droneLoad = (DroneLoad) o;
        return id == droneLoad.id && Objects.equals(drone, droneLoad.drone) && Objects.equals(medication, droneLoad.medication);
    }
}

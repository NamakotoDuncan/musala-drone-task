package com.musala.drone.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table
public class DroneLoad implements Serializable {
    @Id
    @GeneratedValue
    private int id;

    @JsonBackReference
    @ManyToOne(cascade= { CascadeType.ALL})
    @JoinColumn(name="drone_name")
    @NotBlank(message = "Drone mandatory")
    private Drone drone;

    @JsonBackReference
    @ManyToOne(cascade= { CascadeType.ALL})
    @JoinColumn(name="medication_name")
    @NotBlank(message = "Medication mandatory")
    private Medication medication;

}

package com.musala.drone.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table
public class Medication implements Serializable {
    @Id
//    @Pattern(regexp = "/^[A-Za-z0-9_-].*?$/gm")
    private String name;

    @NotNull(message = "Weight mandatory")
    private double weight;

    @NotNull(message = "Code mandatory")
    private String code;

    @Column(name = "image_url")
    @NotNull(message = "Image URL mandatory")
    private String imageUrl;
}

package com.musala.drone.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
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
import java.util.Objects;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table
@JsonIgnoreProperties({"hibernateLazyInitializer"})

public class Medication implements Serializable {
    @Id
   // @Pattern(regexp = "^[A-Za-z0-9_-]*$",message = "Only letters numbers - and _ allowed")
    @Column(name = "name")
    private String name;

    @NotNull(message = "Weight mandatory")
    @Column(name = "weight")
    private double weight;

    @NotNull(message = "Code mandatory")
    @Column(name = "code")
    private String code;

    @Column(name = "image_url")
    @NotNull(message = "Image URL mandatory")
    private String imageUrl;

    @Override
    public int hashCode() {
        return Objects.hash(this.code, this.name, this.imageUrl);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Medication)) return false;
        Medication that = (Medication) o;
        return Double.compare(that.weight, weight) == 0 && Objects.equals(name, that.name) && Objects.equals(code, that.code) && Objects.equals(imageUrl, that.imageUrl);
    }
}

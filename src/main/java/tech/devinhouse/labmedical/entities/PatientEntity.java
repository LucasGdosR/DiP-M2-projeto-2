package tech.devinhouse.labmedical.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Entity
@AllArgsConstructor
@NoArgsConstructor
public class PatientEntity extends Person {
    private String allergyList;
    private String specialNeeds;
    @NotBlank
    private String emergencyContact;
    private String insurance;
    private String insuranceCardId;
    private LocalDate insuranceExpirationDate;
    @ManyToOne
    private AddressEntity address;
}

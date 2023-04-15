package tech.devinhouse.labmedical.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.Enumerated;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import tech.devinhouse.labmedical.enums.Specialization;

@Entity
@AllArgsConstructor
@NoArgsConstructor
public class DoctorEntity extends Person {
    @NotBlank
    private String crm;
    @Enumerated
    private Specialization specialization;
    @Size(min = 8)
    @Pattern(regexp = "^[A-Za-z0-9]*$")
    private String password;
}

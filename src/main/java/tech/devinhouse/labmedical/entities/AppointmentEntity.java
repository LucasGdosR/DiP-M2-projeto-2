package tech.devinhouse.labmedical.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotBlank;
import lombok.*;

import java.time.LocalDateTime;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class AppointmentEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @NotBlank
    private String motive;
    private LocalDateTime dateTime;
    @NotBlank
    private String issueDescription;
    @NotBlank
    private String prescribedMedication;
    @NotBlank
    private String dosageAndPrecautions;
}

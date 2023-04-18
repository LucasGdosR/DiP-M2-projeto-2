package tech.devinhouse.labmedical.entities;

import jakarta.persistence.*;
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
    private String motive;
    private LocalDateTime dateTime;
    private String issueDescription;
    private String prescribedMedication;
    private String dosageAndPrecautions;
    @ManyToOne
    private PatientEntity patient;
}

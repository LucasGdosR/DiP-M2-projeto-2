package tech.devinhouse.labmedical.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

import java.util.Date;
import java.util.List;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@SuperBuilder
@Getter
@Setter
public class PatientEntity extends Person {
    private String allergyList;
    private String specialNeeds;
    private String emergencyContact;
    private String insurance;
    private String insuranceCardId;
    private Date insuranceExpirationDate;
    @ManyToOne
    private AddressEntity address;
    @OneToMany
    private List<AppointmentEntity> appointments;
    @OneToMany
    private List<ExamEntity> exams;
}

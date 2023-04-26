package tech.devinhouse.labmedical.entities;

import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
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

    public AppointmentEntity() {
    }

    public AppointmentEntity(Integer id, String motive, LocalDateTime dateTime, String issueDescription, String prescribedMedication, String dosageAndPrecautions, PatientEntity patient) {
        this.id = id;
        this.motive = motive;
        this.dateTime = dateTime;
        this.issueDescription = issueDescription;
        this.prescribedMedication = prescribedMedication;
        this.dosageAndPrecautions = dosageAndPrecautions;
        this.patient = patient;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getMotive() {
        return motive;
    }

    public void setMotive(String motive) {
        this.motive = motive;
    }

    public LocalDateTime getDateTime() {
        return dateTime;
    }

    public void setDateTime(LocalDateTime dateTime) {
        this.dateTime = dateTime;
    }

    public String getIssueDescription() {
        return issueDescription;
    }

    public void setIssueDescription(String issueDescription) {
        this.issueDescription = issueDescription;
    }

    public String getPrescribedMedication() {
        return prescribedMedication;
    }

    public void setPrescribedMedication(String prescribedMedication) {
        this.prescribedMedication = prescribedMedication;
    }

    public String getDosageAndPrecautions() {
        return dosageAndPrecautions;
    }

    public void setDosageAndPrecautions(String dosageAndPrecautions) {
        this.dosageAndPrecautions = dosageAndPrecautions;
    }

    public PatientEntity getPatient() {
        return patient;
    }

    public void setPatient(PatientEntity patient) {
        this.patient = patient;
    }
}

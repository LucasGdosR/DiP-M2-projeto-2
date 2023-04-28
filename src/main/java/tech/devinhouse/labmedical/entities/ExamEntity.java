package tech.devinhouse.labmedical.entities;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
public class ExamEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String name;
    @Column(name = "date_time")
    private LocalDateTime dateTime;
    private String type;
    private String laboratory;
    private String file;
    private String results;
    @ManyToOne
    private PatientEntity patient;
    @ManyToOne
    private DoctorEntity doctor;

    public ExamEntity() {
    }

    public ExamEntity(Integer id, String name, LocalDateTime dateTime, String type, String laboratory, String file, String results, PatientEntity patient, DoctorEntity doctor) {
        this.id = id;
        this.name = name;
        this.dateTime = dateTime;
        this.type = type;
        this.laboratory = laboratory;
        this.file = file;
        this.results = results;
        this.patient = patient;
        this.doctor = doctor;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocalDateTime getDateTime() {
        return dateTime;
    }

    public void setDateTime(LocalDateTime dateTime) {
        this.dateTime = dateTime;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getLaboratory() {
        return laboratory;
    }

    public void setLaboratory(String laboratory) {
        this.laboratory = laboratory;
    }

    public String getFile() {
        return file;
    }

    public void setFile(String file) {
        this.file = file;
    }

    public String getResults() {
        return results;
    }

    public void setResults(String results) {
        this.results = results;
    }

    public PatientEntity getPatient() {
        return patient;
    }

    public void setPatient(PatientEntity patient) {
        this.patient = patient;
    }

    public DoctorEntity getDoctor() {
        return doctor;
    }

    public void setDoctor(DoctorEntity doctor) {
        this.doctor = doctor;
    }
}

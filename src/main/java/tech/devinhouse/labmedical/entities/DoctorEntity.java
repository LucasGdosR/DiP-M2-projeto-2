package tech.devinhouse.labmedical.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import lombok.experimental.SuperBuilder;

import java.util.Date;
import java.util.List;

@Entity
@SuperBuilder
public class DoctorEntity extends Person {
    private String crm;
    private Integer specialization;
    private String password;
    @OneToMany
    private List<AppointmentEntity> appointments;
    @OneToMany
    private List<ExamEntity> exams;

    public DoctorEntity() {
    }

    public DoctorEntity(java.lang.Integer id, String fullName, String gender, Date birthday, String cpf, String rg, Integer maritalStatus, String telephone, String email, String placeOfBirth, String crm, Integer specialization, String password) {
        super(id, fullName, gender, birthday, cpf, rg, maritalStatus, telephone, email, placeOfBirth);
        this.crm = crm;
        this.specialization = specialization;
        this.password = password;
    }

    public String getCrm() {
        return crm;
    }

    public void setCrm(String crm) {
        this.crm = crm;
    }

    public Integer getSpecialization() {
        return specialization;
    }

    public void setSpecialization(Integer specialization) {
        this.specialization = specialization;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}

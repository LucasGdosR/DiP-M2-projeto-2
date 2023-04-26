package tech.devinhouse.labmedical.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.Enumerated;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.experimental.SuperBuilder;
import tech.devinhouse.labmedical.enums.MaritalStatus;
import tech.devinhouse.labmedical.enums.Specialization;

import java.util.Date;

@Entity
@SuperBuilder
public class DoctorEntity extends Person {
    private String crm;
    @Enumerated
    private Specialization specialization;
    @Size(min = 8)
    @Pattern(regexp = "^[A-Za-z0-9]*$")
    private String password;

    public DoctorEntity() {
    }

    public DoctorEntity(Integer id, String fullName, String gender, Date birthday, String cpf, String rg, MaritalStatus maritalStatus, String telephone, String email, String placeOfBirth, String crm, Specialization specialization, String password) {
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

    public Specialization getSpecialization() {
        return specialization;
    }

    public void setSpecialization(Specialization specialization) {
        this.specialization = specialization;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}

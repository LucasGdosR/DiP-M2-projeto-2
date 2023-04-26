package tech.devinhouse.labmedical.entities;

import jakarta.persistence.*;
import tech.devinhouse.labmedical.enums.MaritalStatus;

import java.util.Date;

@MappedSuperclass
public abstract class Person {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    protected Integer id;
    protected String fullName;
    protected String gender;
    protected Date birthday;
    protected String cpf;
    protected String rg;
    @Enumerated
    protected MaritalStatus maritalStatus;
    protected String telephone;
    protected String email;
    protected String placeOfBirth;

    public Person() {
    }

    public Person(Integer id, String fullName, String gender, Date birthday, String cpf, String rg, MaritalStatus maritalStatus, String telephone, String email, String placeOfBirth) {
        this.id = id;
        this.fullName = fullName;
        this.gender = gender;
        this.birthday = birthday;
        this.cpf = cpf;
        this.rg = rg;
        this.maritalStatus = maritalStatus;
        this.telephone = telephone;
        this.email = email;
        this.placeOfBirth = placeOfBirth;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getRg() {
        return rg;
    }

    public void setRg(String rg) {
        this.rg = rg;
    }

    public MaritalStatus getMaritalStatus() {
        return maritalStatus;
    }

    public void setMaritalStatus(MaritalStatus maritalStatus) {
        this.maritalStatus = maritalStatus;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPlaceOfBirth() {
        return placeOfBirth;
    }

    public void setPlaceOfBirth(String placeOfBirth) {
        this.placeOfBirth = placeOfBirth;
    }
}

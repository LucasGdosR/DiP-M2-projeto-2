package tech.devinhouse.labmedical.dtos;

import tech.devinhouse.labmedical.entities.AppointmentEntity;
import tech.devinhouse.labmedical.entities.ExamEntity;

import java.util.List;

public class PatientResponse {
    private String fullName;
    private String gender;
    private String birthday;
    private String cpf;
    private String rg;
    private Integer maritalStatus;
    private String telephone;
    private String email;
    private String placeOfBirth;
    private String allergyList;
    private String specialNeeds;
    private String emergencyContact;
    private String insurance;
    private String insuranceCardId;
    private String insuranceExpirationDate;
    private Integer addressId;
    private List<Integer> appointmentIds;
    private List<Integer> examIds;

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

    public String getBirthday() {
        return birthday;
    }

    public void setBirthday(String birthday) {
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

    public Integer getMaritalStatus() {
        return maritalStatus;
    }

    public void setMaritalStatus(Integer maritalStatus) {
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

    public String getAllergyList() {
        return allergyList;
    }

    public void setAllergyList(String allergyList) {
        this.allergyList = allergyList;
    }

    public String getSpecialNeeds() {
        return specialNeeds;
    }

    public void setSpecialNeeds(String specialNeeds) {
        this.specialNeeds = specialNeeds;
    }

    public String getEmergencyContact() {
        return emergencyContact;
    }

    public void setEmergencyContact(String emergencyContact) {
        this.emergencyContact = emergencyContact;
    }

    public String getInsurance() {
        return insurance;
    }

    public void setInsurance(String insurance) {
        this.insurance = insurance;
    }

    public String getInsuranceCardId() {
        return insuranceCardId;
    }

    public void setInsuranceCardId(String insuranceCardId) {
        this.insuranceCardId = insuranceCardId;
    }

    public String getInsuranceExpirationDate() {
        return insuranceExpirationDate;
    }

    public void setInsuranceExpirationDate(String insuranceExpirationDate) {
        this.insuranceExpirationDate = insuranceExpirationDate;
    }

    public Integer getAddressId() {
        return addressId;
    }

    public void setAddressId(Integer addressId) {
        this.addressId = addressId;
    }

    public List<Integer> getAppointmentIds() {
        return appointmentIds;
    }

    public void setAppointmentIds(List<Integer> appointmentIds) {
        this.appointmentIds = appointmentIds;
    }

    public List<Integer> getExamIds() {
        return examIds;
    }

    public void setExamIds(List<Integer> examIds) {
        this.examIds = examIds;
    }
}

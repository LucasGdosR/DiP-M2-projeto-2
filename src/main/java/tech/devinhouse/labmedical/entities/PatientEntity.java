package tech.devinhouse.labmedical.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import lombok.experimental.SuperBuilder;
import tech.devinhouse.labmedical.enums.MaritalStatus;

import java.util.Date;
import java.util.List;

@Entity
@SuperBuilder
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

    public PatientEntity() {
    }

    public PatientEntity(Integer id, String fullName, String gender, Date birthday, String cpf, String rg, MaritalStatus maritalStatus, String telephone, String email, String placeOfBirth, String allergyList, String specialNeeds, String emergencyContact, String insurance, String insuranceCardId, Date insuranceExpirationDate, AddressEntity address, List<AppointmentEntity> appointments, List<ExamEntity> exams) {
        super(id, fullName, gender, birthday, cpf, rg, maritalStatus, telephone, email, placeOfBirth);
        this.allergyList = allergyList;
        this.specialNeeds = specialNeeds;
        this.emergencyContact = emergencyContact;
        this.insurance = insurance;
        this.insuranceCardId = insuranceCardId;
        this.insuranceExpirationDate = insuranceExpirationDate;
        this.address = address;
        this.appointments = appointments;
        this.exams = exams;
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

    public Date getInsuranceExpirationDate() {
        return insuranceExpirationDate;
    }

    public void setInsuranceExpirationDate(Date insuranceExpirationDate) {
        this.insuranceExpirationDate = insuranceExpirationDate;
    }

    public AddressEntity getAddress() {
        return address;
    }

    public void setAddress(AddressEntity address) {
        this.address = address;
    }

    public List<AppointmentEntity> getAppointments() {
        return appointments;
    }

    public void setAppointments(List<AppointmentEntity> appointments) {
        this.appointments = appointments;
    }

    public List<ExamEntity> getExams() {
        return exams;
    }

    public void setExams(List<ExamEntity> exams) {
        this.exams = exams;
    }
}

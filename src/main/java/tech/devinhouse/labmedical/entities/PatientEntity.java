package tech.devinhouse.labmedical.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import lombok.experimental.SuperBuilder;

import java.util.Date;
import java.util.List;

@Entity
@SuperBuilder
public class PatientEntity extends Person {
    @Column(name = "allergy_list")
    private String allergyList;
    @Column(name = "special_needs")
    private String specialNeeds;
    @Column(name = "emergency_contact")
    private String emergencyContact;
    private String insurance;
    @Column(name = "insurance_card_id")
    private String insuranceCardId;
    @Column(name = "insurance_expiration_date")
    private Date insuranceExpirationDate;
    @ManyToOne
    private AddressEntity address;

    public PatientEntity() {
    }

    public PatientEntity(java.lang.Integer id, String fullName, String gender, Date birthday, String cpf, String rg, Integer maritalStatus, String telephone, String email, String placeOfBirth, String allergyList, String specialNeeds, String emergencyContact, String insurance, String insuranceCardId, Date insuranceExpirationDate, AddressEntity address, List<AppointmentEntity> appointments, List<ExamEntity> exams) {
        super(id, fullName, gender, birthday, cpf, rg, maritalStatus, telephone, email, placeOfBirth);
        this.allergyList = allergyList;
        this.specialNeeds = specialNeeds;
        this.emergencyContact = emergencyContact;
        this.insurance = insurance;
        this.insuranceCardId = insuranceCardId;
        this.insuranceExpirationDate = insuranceExpirationDate;
        this.address = address;
        //this.appointments = appointments;
        //this.exams = exams;
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
}

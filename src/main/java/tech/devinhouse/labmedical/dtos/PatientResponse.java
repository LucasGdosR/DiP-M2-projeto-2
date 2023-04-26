package tech.devinhouse.labmedical.dtos;

import lombok.*;
import tech.devinhouse.labmedical.entities.AddressEntity;
import tech.devinhouse.labmedical.entities.AppointmentEntity;
import tech.devinhouse.labmedical.entities.ExamEntity;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class PatientResponse {
    private String fullName;
    private String gender;
    private String birthday;
    private String cpf;
    private String rg;
    private String maritalStatus;
    private String telephone;
    private String email;
    private String placeOfBirth;
    private String allergyList;
    private String specialNeeds;
    private String emergencyContact;
    private String insurance;
    private String insuranceCardId;
    private String insuranceExpirationDate;
    private AddressEntity address;
    private List<AppointmentEntity> appointments;
    private List<ExamEntity> exams;

}

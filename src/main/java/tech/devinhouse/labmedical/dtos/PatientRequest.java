package tech.devinhouse.labmedical.dtos;

import jakarta.persistence.Enumerated;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.validator.constraints.br.CPF;
import tech.devinhouse.labmedical.enums.MaritalStatus;

import java.util.Date;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class PatientRequest {
    @NotBlank
    private String fullName;
    @NotBlank
    private String gender;
    @NotBlank
    private String birthday;
    @CPF @NotBlank
    private String cpf;
    @NotBlank
    private String rg;
    @Enumerated @NotBlank
    private MaritalStatus maritalStatus;
    @NotBlank
    private String telephone;
    @Email
    @NotBlank
    private String email;
    @NotBlank
    private String placeOfBirth;
    private String allergyList;
    private String specialNeeds;
    @NotBlank
    private String emergencyContact;
    private String insurance;
    private String insuranceCardId;
    private Date insuranceExpirationDate;
    @NotBlank
    private Integer addressId;
}

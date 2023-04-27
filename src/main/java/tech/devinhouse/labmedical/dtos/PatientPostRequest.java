package tech.devinhouse.labmedical.dtos;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.validator.constraints.br.CPF;

import java.util.Date;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class PatientPostRequest {
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
    @Min(0) @Max(4)
    private Integer maritalStatus;
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
    private java.lang.Integer addressId;
}

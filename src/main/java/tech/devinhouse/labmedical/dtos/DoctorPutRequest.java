package tech.devinhouse.labmedical.dtos;

import jakarta.persistence.Enumerated;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.*;
import org.hibernate.validator.constraints.br.CPF;
import tech.devinhouse.labmedical.enums.MaritalStatus;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class DoctorPutRequest {
    @NotBlank
    private String fullName;
    @NotBlank
    private String gender;
    @NotBlank
    private String birthday;
    @CPF
    @NotBlank
    private String cpf;
    @NotBlank
    private String rg;
    @Enumerated
    @NotBlank
    private MaritalStatus maritalStatus;
    @NotBlank
    private String telephone;
    @Email
    @NotBlank
    private String email;
    @NotBlank
    private String placeOfBirth;
    @NotBlank
    private String crm;
    @Enumerated
    private String specialization;
}

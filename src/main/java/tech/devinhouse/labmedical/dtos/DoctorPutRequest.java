package tech.devinhouse.labmedical.dtos;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import lombok.*;
import org.hibernate.validator.constraints.br.CPF;

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
    @Min(0) @Max(4)
    private Integer maritalStatus;
    @NotBlank
    private String telephone;
    @Email
    @NotBlank
    private String email;
    @NotBlank
    private String placeOfBirth;
    @NotBlank
    private String crm;
    @Min(0) @Max(7)
    private String specialization;
}

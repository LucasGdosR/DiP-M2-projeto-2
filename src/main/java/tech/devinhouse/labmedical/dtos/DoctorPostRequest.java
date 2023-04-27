package tech.devinhouse.labmedical.dtos;

import jakarta.validation.constraints.*;
import lombok.*;
import org.hibernate.validator.constraints.br.CPF;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class DoctorPostRequest {
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
    @Size(min = 8)
    @Pattern(regexp = "^[A-Za-z0-9]*$")
    private String password;
}

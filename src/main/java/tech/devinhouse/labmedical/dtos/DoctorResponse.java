package tech.devinhouse.labmedical.dtos;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class DoctorResponse {
    private String fullName;
    private String gender;
    private String birthday;
    private String cpf;
    private String rg;
    private String maritalStatus;
    private String telephone;
    private String email;
    private String placeOfBirth;
    private String crm;
    private String specialization;
    private String password;
}

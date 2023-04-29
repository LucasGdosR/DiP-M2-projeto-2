package tech.devinhouse.labmedical.dtos;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.validation.constraints.*;
import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Builder
public class DoctorPutRequest {
    @NotBlank
    private String fullName;
    @NotBlank
    private String gender;
    @NotBlank
    @JsonFormat(pattern = "dd-MM-yyyy")
    private String birthday;
    @NotNull
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
    @NotNull
    @Min(0) @Max(7)
    private Integer specialization;

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

    public String getCrm() {
        return crm;
    }

    public void setCrm(String crm) {
        this.crm = crm;
    }

    public Integer getSpecialization() {
        return specialization;
    }

    public void setSpecialization(Integer specialization) {
        this.specialization = specialization;
    }
}

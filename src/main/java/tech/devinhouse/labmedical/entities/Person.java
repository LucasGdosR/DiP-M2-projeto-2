package tech.devinhouse.labmedical.entities;

import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.validator.constraints.br.CPF;
import tech.devinhouse.labmedical.enums.MaritalStatus;

import java.time.LocalDate;

@Getter
@Setter
public abstract class Person {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    protected Integer id;
    @NotBlank
    protected String fullName;
    @NotBlank
    protected String gender;
    @NotBlank
    protected LocalDate birthday;
    @CPF
    protected String cpf;
    @NotBlank
    protected String rg;
    @Enumerated
    protected MaritalStatus maritalStatus;
    @NotBlank
    protected String telephone;
    @Email
    @NotBlank
    protected String email;
    @NotBlank
    protected String placeOfBirth;
}

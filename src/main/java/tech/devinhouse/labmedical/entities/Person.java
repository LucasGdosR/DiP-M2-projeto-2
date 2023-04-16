package tech.devinhouse.labmedical.entities;

import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.*;
import tech.devinhouse.labmedical.enums.MaritalStatus;

import java.util.Date;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public abstract class Person {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    protected Integer id;
    protected String fullName;
    protected String gender;
    protected Date birthday;
    protected String cpf;
    protected String rg;
    @Enumerated
    protected MaritalStatus maritalStatus;
    protected String telephone;
    protected String email;
    protected String placeOfBirth;
}

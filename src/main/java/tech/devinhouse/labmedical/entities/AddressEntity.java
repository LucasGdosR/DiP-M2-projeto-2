package tech.devinhouse.labmedical.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotBlank;
import lombok.*;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class AddressEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @NotBlank
    private String cep;
    @NotBlank
    private String city;
    @NotBlank
    private String state;
    @NotBlank
    private String street;
    @NotBlank
    private String number;
    private String complement;
    @NotBlank
    private String neighborhood;
    private String reference;
}

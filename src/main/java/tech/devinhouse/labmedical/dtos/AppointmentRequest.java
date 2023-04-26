package tech.devinhouse.labmedical.dtos;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class AppointmentRequest {
    @NotBlank
    private String motive;
    @NotBlank
    private String issueDescription;
    @NotBlank
    private String prescribedMedication;
    @NotBlank
    private String dosageAndPrecautions;
    @NotBlank
    private Integer doctorId;
    @NotBlank
    private Integer patientId;
}

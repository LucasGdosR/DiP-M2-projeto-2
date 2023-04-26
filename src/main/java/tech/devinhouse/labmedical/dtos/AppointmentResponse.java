package tech.devinhouse.labmedical.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AppointmentResponse {
    private String motive;
    private String dateTime;
    private String issueDescription;
    private String prescribedMedication;
    private String dosageAndPrecautions;
    private Integer doctorId;
    private Integer patientId;
}

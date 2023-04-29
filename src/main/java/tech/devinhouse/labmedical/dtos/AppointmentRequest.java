package tech.devinhouse.labmedical.dtos;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

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
    @NotNull
    private Integer doctorId;
    @NotNull
    private Integer patientId;

    public String getMotive() {
        return motive;
    }

    public void setMotive(String motive) {
        this.motive = motive;
    }

    public String getIssueDescription() {
        return issueDescription;
    }

    public void setIssueDescription(String issueDescription) {
        this.issueDescription = issueDescription;
    }

    public String getPrescribedMedication() {
        return prescribedMedication;
    }

    public void setPrescribedMedication(String prescribedMedication) {
        this.prescribedMedication = prescribedMedication;
    }

    public String getDosageAndPrecautions() {
        return dosageAndPrecautions;
    }

    public void setDosageAndPrecautions(String dosageAndPrecautions) {
        this.dosageAndPrecautions = dosageAndPrecautions;
    }

    public Integer getDoctorId() {
        return doctorId;
    }

    public void setDoctorId(Integer doctorId) {
        this.doctorId = doctorId;
    }

    public Integer getPatientId() {
        return patientId;
    }

    public void setPatientId(Integer patientId) {
        this.patientId = patientId;
    }
}

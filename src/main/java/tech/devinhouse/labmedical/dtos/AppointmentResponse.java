package tech.devinhouse.labmedical.dtos;

public class AppointmentResponse {
    private String motive;
    private String dateTime;
    private String issueDescription;
    private String prescribedMedication;
    private String dosageAndPrecautions;
    private Integer doctorId;
    private Integer patientId;

    public String getMotive() {
        return motive;
    }

    public void setMotive(String motive) {
        this.motive = motive;
    }

    public String getDateTime() {
        return dateTime;
    }

    public void setDateTime(String dateTime) {
        this.dateTime = dateTime;
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

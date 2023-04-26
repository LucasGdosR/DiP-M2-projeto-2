package tech.devinhouse.labmedical.dtos;

public class Statistics {
    private final Integer patients;
    private final Integer appointments;
    private final Integer exams;

    public Statistics(Integer patients, Integer appointments, Integer exams) {
        this.patients = patients;
        this.appointments = appointments;
        this.exams = exams;
    }

    public Integer getPatients() {
        return patients;
    }

    public Integer getAppointments() {
        return appointments;
    }

    public Integer getExams() {
        return exams;
    }
}

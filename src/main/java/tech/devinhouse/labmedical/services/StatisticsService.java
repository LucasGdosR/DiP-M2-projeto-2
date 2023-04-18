package tech.devinhouse.labmedical.services;

import org.springframework.stereotype.Service;
import tech.devinhouse.labmedical.dtos.Statistics;

@Service
public class StatisticsService {
    private final AppointmentService appointmentService;
    private final ExamService examService;
    private final PatientService patientService;

    public StatisticsService(AppointmentService appointmentService, ExamService examService, PatientService patientService) {
        this.appointmentService = appointmentService;
        this.examService = examService;
        this.patientService = patientService;
    }

    public Statistics getStatistics() {
        return new Statistics(
                patientService.findAll().size(),
                appointmentService.findAll().size(),
                examService.findAll().size());
    }
}

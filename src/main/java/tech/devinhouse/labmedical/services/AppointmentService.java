package tech.devinhouse.labmedical.services;

import org.springframework.stereotype.Service;
import tech.devinhouse.labmedical.dtos.AppointmentRequest;
import tech.devinhouse.labmedical.dtos.AppointmentResponse;
import tech.devinhouse.labmedical.entities.AppointmentEntity;
import tech.devinhouse.labmedical.exceptions.NoSuchAppointmentException;
import tech.devinhouse.labmedical.exceptions.NoSuchPatientException;
import tech.devinhouse.labmedical.mappers.AppointmentMapper;
import tech.devinhouse.labmedical.repositories.AppointmentRepository;

@Service
public class AppointmentService {
    private final PatientService patientService;
    private final AppointmentMapper mapper;
    private final AppointmentRepository repository;

    public AppointmentService(PatientService patientService, AppointmentMapper mapper, AppointmentRepository repository) {
        this.patientService = patientService;
        this.mapper = mapper;
        this.repository = repository;
    }

    public AppointmentResponse register(AppointmentRequest request) throws NoSuchPatientException {
        patientService.findById(request.getPatientId());

        AppointmentEntity appointment = mapper.map(request);

        return mapper.map(repository.save(appointment));
    }

    public AppointmentResponse update(Integer id, AppointmentRequest request) throws NoSuchPatientException {
        patientService.findById(request.getPatientId());

        AppointmentEntity oldAppointment = repository.findById(id).orElseThrow(NoSuchAppointmentException::new);
        AppointmentEntity updatedAppointment = mapper.map(request);
        updatedAppointment.setId(oldAppointment.getId());
        updatedAppointment.setDateTime(oldAppointment.getDateTime());

        return mapper.map(repository.save(updatedAppointment));
    }

    public AppointmentResponse findById(Integer id) {
        return mapper.map(repository.findById(id).orElseThrow(NoSuchAppointmentException::new));
    }

    public void deleteById(Integer id) {
        repository.findById(id).orElseThrow(NoSuchAppointmentException::new);
        repository.deleteById(id);
    }
}

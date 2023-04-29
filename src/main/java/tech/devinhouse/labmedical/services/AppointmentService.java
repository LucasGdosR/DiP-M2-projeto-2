package tech.devinhouse.labmedical.services;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;
import tech.devinhouse.labmedical.dtos.AppointmentRequest;
import tech.devinhouse.labmedical.dtos.AppointmentResponse;
import tech.devinhouse.labmedical.entities.AppointmentEntity;
import tech.devinhouse.labmedical.mappers.AppointmentMapper;
import tech.devinhouse.labmedical.repositories.AppointmentRepository;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class AppointmentService {
    private final DoctorService doctorService;
    private final PatientService patientService;
    private final AppointmentMapper mapper;
    private final AppointmentRepository repository;

    public AppointmentService(DoctorService doctorService, PatientService patientService, AppointmentMapper mapper, AppointmentRepository repository) {
        this.doctorService = doctorService;
        this.patientService = patientService;
        this.mapper = mapper;
        this.repository = repository;
    }

    public AppointmentEntity register(AppointmentRequest request) throws ResponseStatusException {
        doctorService.findById(request.getDoctorId());
        patientService.findById(request.getPatientId());

        AppointmentEntity appointment = mapper.map(request);
        appointment.setDateTime(LocalDateTime.now());

        return repository.save(appointment);
    }

    public AppointmentResponse update(Integer id, AppointmentRequest request) throws ResponseStatusException {
        doctorService.findById(request.getDoctorId());
        patientService.findById(request.getPatientId());

        AppointmentEntity oldAppointment = repository.findById(id).orElseThrow(() -> new ResponseStatusException(
                HttpStatus.NOT_FOUND, "Id de exame não existente"));

        AppointmentEntity updatedAppointment = mapper.map(request);

        updatedAppointment.setId(oldAppointment.getId());
        updatedAppointment.setDateTime(oldAppointment.getDateTime());

        return mapper.map(repository.save(updatedAppointment));
    }

    public AppointmentResponse findById(Integer id) {
        return mapper.map(repository.findById(id).orElseThrow(() -> new ResponseStatusException(
                HttpStatus.NOT_FOUND, "Id de exame não existente")));
    }

    public void deleteById(Integer id) {
        repository.findById(id).orElseThrow(() -> new ResponseStatusException(
                HttpStatus.NOT_FOUND, "Id de exame não existente"));

        repository.deleteById(id);
    }

    public List<AppointmentEntity> findAll() {
        return repository.findAll();
    }
}

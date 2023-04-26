package tech.devinhouse.labmedical.services;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;
import tech.devinhouse.labmedical.dtos.ExamRequest;
import tech.devinhouse.labmedical.dtos.ExamResponse;
import tech.devinhouse.labmedical.entities.ExamEntity;
import tech.devinhouse.labmedical.mappers.ExamMapper;
import tech.devinhouse.labmedical.repositories.ExamRepository;

import java.util.List;

@Service
public class ExamService {
    private final DoctorService doctorService;
    private final PatientService patientService;
    private final ExamMapper mapper;
    private final ExamRepository repository;

    public ExamService(DoctorService doctorService, PatientService patientService, ExamMapper mapper, ExamRepository repository) {
        this.doctorService = doctorService;
        this.patientService = patientService;
        this.mapper = mapper;
        this.repository = repository;
    }

    public ExamEntity register(ExamRequest request) throws ResponseStatusException {
        doctorService.findById(request.getDoctorId());
        patientService.findById(request.getPatientId());

        ExamEntity exam = mapper.map(request);

        return repository.save(exam);
    }

    public ExamResponse update(Integer id, ExamRequest request) throws ResponseStatusException {
        doctorService.findById(request.getDoctorId());
        patientService.findById(request.getPatientId());

        ExamEntity oldExam = repository.findById(id).orElseThrow(() -> new ResponseStatusException(
                HttpStatus.NOT_FOUND, "Id de consulta não existente"));

        ExamEntity updatedExam = mapper.map(request);
        updatedExam.setId(oldExam.getId());
        updatedExam.setDateTime(oldExam.getDateTime());

        return mapper.map(repository.save(updatedExam));
    }

    public ExamResponse findById(Integer id) {
        return mapper.map(repository.findById(id).orElseThrow(() -> new ResponseStatusException(
                HttpStatus.NOT_FOUND, "Id de consulta não existente")));
    }

    public void deleteById(Integer id) {
        repository.findById(id).orElseThrow(() -> new ResponseStatusException(
                        HttpStatus.NOT_FOUND, "Id de consulta não existente"));

        repository.deleteById(id);
    }

    public List<ExamEntity> findAll() {
        return repository.findAll();
    }
}

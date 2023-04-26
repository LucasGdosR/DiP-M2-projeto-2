package tech.devinhouse.labmedical.services;

import org.springframework.stereotype.Service;
import tech.devinhouse.labmedical.dtos.ExamRequest;
import tech.devinhouse.labmedical.dtos.ExamResponse;
import tech.devinhouse.labmedical.entities.ExamEntity;
import tech.devinhouse.labmedical.exceptions.NoSuchExamException;
import tech.devinhouse.labmedical.exceptions.NoSuchPatientException;
import tech.devinhouse.labmedical.mappers.ExamMapper;
import tech.devinhouse.labmedical.repositories.ExamRepository;

import java.util.List;

@Service
public class ExamService {
    private final PatientService patientService;
    private final ExamMapper mapper;
    private final ExamRepository repository;

    public ExamService(PatientService patientService, ExamMapper mapper, ExamRepository repository) {
        this.patientService = patientService;
        this.mapper = mapper;
        this.repository = repository;
    }

    public ExamResponse register(ExamRequest request) throws NoSuchPatientException {
        patientService.findById(request.getPatientId());

        ExamEntity exam = mapper.map(request);

        return mapper.map(repository.save(exam));
    }

    public ExamResponse update(Integer id, ExamRequest request) throws NoSuchPatientException {
        patientService.findById(request.getPatientId());

        ExamEntity oldExam = repository.findById(id).orElseThrow(NoSuchExamException::new);
        ExamEntity updatedExam = mapper.map(request);
        updatedExam.setId(oldExam.getId());
        updatedExam.setDateTime(oldExam.getDateTime());

        return mapper.map(repository.save(updatedExam));
    }

    public ExamResponse findById(Integer id) {
        return mapper.map(repository.findById(id).orElseThrow(NoSuchExamException::new));
    }

    public void deleteById(Integer id) {
        repository.findById(id).orElseThrow(NoSuchExamException::new);
        repository.deleteById(id);
    }

    public List<ExamEntity> findAll() {
        return repository.findAll();
    }
}

package tech.devinhouse.labmedical.services;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;
import tech.devinhouse.labmedical.dtos.PatientPostRequest;
import tech.devinhouse.labmedical.dtos.PatientPutRequest;
import tech.devinhouse.labmedical.dtos.PatientResponse;
import tech.devinhouse.labmedical.entities.PatientEntity;
import tech.devinhouse.labmedical.mappers.PatientMapper;
import tech.devinhouse.labmedical.repositories.AppointmentRepository;
import tech.devinhouse.labmedical.repositories.ExamRepository;
import tech.devinhouse.labmedical.repositories.PatientRepository;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Service
public class PatientService {
    private final AddressService addressService;
    private final AppointmentRepository appointmentRepository;
    private final ExamRepository examRepository;
    private final PatientMapper mapper;
    private final PatientRepository repository;

    public PatientService(AddressService addressService, AppointmentRepository appointmentRepository, ExamRepository examRepository, PatientMapper mapper, PatientRepository repository) {
        this.addressService = addressService;
        this.appointmentRepository = appointmentRepository;
        this.examRepository = examRepository;
        this.mapper = mapper;
        this.repository = repository;
    }

    public PatientEntity register(PatientPostRequest request) {
        validateBirthday(request.getBirthday());
        validateAddress(request.getAddressId());
        validateUniqueCPF(request.getCpf());

        PatientEntity newPatient = mapper.map(request);
        newPatient.setAddress(addressService.findById(request.getAddressId()));

        return repository.save(newPatient);
    }

    private void validateBirthday(String birthday) {
        SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy");
        try {
            Date birthdate = formatter.parse(birthday);
            if (birthdate.after(new Date())) throw new ResponseStatusException(
                    HttpStatus.BAD_REQUEST, "Data de nascimento no futuro");
        } catch (ParseException e) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Formato de data inválida");
        }
    }

    private void validateAddress(Integer id) throws ResponseStatusException {
        addressService.findById(id);
    }

    private void validateUniqueCPF(String cpf) {
        repository.findByCpf(cpf).ifPresent(
                e -> {throw new ResponseStatusException(HttpStatus.CONFLICT, "CPF duplicado");});
    }

    public PatientResponse update(Integer id, PatientPutRequest request) {
        validateBirthday(request.getBirthday());
        validateAddress(request.getAddressId());

        PatientEntity oldPatient = repository.findById(id).orElseThrow(() -> new ResponseStatusException(
                HttpStatus.NOT_FOUND, "Id de paciente inválido"));

        PatientEntity updatedPatient = mapper.map(request);

        updatedPatient.setId(oldPatient.getId());
        updatedPatient.setCpf(oldPatient.getCpf());
        updatedPatient.setRg(oldPatient.getRg());

        updatedPatient.setAddress(addressService.findById(request.getAddressId()));

        return mapper.map(repository.save(updatedPatient));
    }

    public List<PatientResponse> findAll() {
        return mapper.map(repository.findAll());
    }

    public List<PatientResponse> findByFullName(String name) {
        return mapper.map(repository.findByFullNameContainingIgnoreCase(name));
    }

    public PatientResponse findById(Integer id) {
        return mapper.map(repository.findById(id).orElseThrow(() -> new ResponseStatusException(
                HttpStatus.NOT_FOUND, "Id de paciente inválido")));
    }

    public void deleteById(Integer id) {
        PatientEntity patient = repository.findById(id).orElseThrow(() -> new ResponseStatusException(
                HttpStatus.NOT_FOUND, "Id de paciente inválido"));

        if (appointmentRepository.findByPatient(patient).size() > 0 || examRepository.findByPatient(patient).size() > 0)
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Paciente possui consulta ou exame");

        repository.deleteById(id);
    }

    public PatientEntity findEntityById(Integer id) {
        return repository.findById(id).orElseThrow(() -> new ResponseStatusException(
                HttpStatus.BAD_REQUEST, "Id de paciente inválido"));
    }
}

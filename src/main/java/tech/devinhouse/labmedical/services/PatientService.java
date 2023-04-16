package tech.devinhouse.labmedical.services;

import lombok.SneakyThrows;
import org.springframework.stereotype.Service;
import tech.devinhouse.labmedical.dtos.PatientPostRequest;
import tech.devinhouse.labmedical.dtos.PatientPutRequest;
import tech.devinhouse.labmedical.dtos.PatientResponse;
import tech.devinhouse.labmedical.entities.PatientEntity;
import tech.devinhouse.labmedical.exceptions.DuplicateCpfException;
import tech.devinhouse.labmedical.exceptions.IllegalBirthdayException;
import tech.devinhouse.labmedical.exceptions.NoSuchAddressException;
import tech.devinhouse.labmedical.exceptions.NoSuchPatientException;
import tech.devinhouse.labmedical.mappers.PatientMapper;
import tech.devinhouse.labmedical.repositories.PatientRepository;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Service
public class PatientService {
    private final AddressService addressService;
    private final PatientMapper mapper;
    private final PatientRepository repository;

    public PatientService(AddressService addressService, PatientMapper mapper, PatientRepository repository) {
        this.addressService = addressService;
        this.mapper = mapper;
        this.repository = repository;
    }

    public PatientResponse register(PatientPostRequest request) {
        validateBirthday(request.getBirthday());
        validateAddress(request.getAddressId());
        validateUniqueCPF(request.getCpf());

        PatientEntity newPatient = mapper.map(request);

        return mapper.map(repository.save(newPatient));
    }

    @SneakyThrows
    private void validateBirthday(String birthday) {
        SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyy");
        Date birthdate = formatter.parse(birthday);
        if (birthdate.after(new Date())) throw new IllegalBirthdayException();
    }

    private void validateAddress(Integer id) throws NoSuchAddressException {
        addressService.findById(id);
    }

    private void validateUniqueCPF(String cpf) {
        repository.findByCpf(cpf).ifPresent(e -> {throw new DuplicateCpfException();});
    }

    public PatientResponse update(Integer id, PatientPutRequest request) {
        validateBirthday(request.getBirthday());
        validateAddress(request.getAddressId());

        PatientEntity oldPatient = repository.findById(id).orElseThrow(NoSuchPatientException::new);
        PatientEntity updatedPatient = mapper.map(request);
        updatedPatient.setId(oldPatient.getId());
        updatedPatient.setCpf(oldPatient.getCpf());
        updatedPatient.setRg(oldPatient.getRg());

        return mapper.map(repository.save(updatedPatient));
    }

    public List<PatientResponse> findAll() {
        return mapper.map(repository.findAll());
    }

    public List<PatientResponse> findByFullName(String name) {
        return mapper.map(repository.findByFullNameContainingIgnoreCase(name));
    }

    public PatientResponse findById(Integer id) {
        return mapper.map(repository.findById(id).orElseThrow(NoSuchPatientException::new));
    }

    public void deleteById(Integer id) {
        // ToDo
    }
}

package tech.devinhouse.labmedical.services;

import lombok.SneakyThrows;
import org.springframework.stereotype.Service;
import tech.devinhouse.labmedical.dtos.PatientRequest;
import tech.devinhouse.labmedical.dtos.PatientResponse;
import tech.devinhouse.labmedical.entities.PatientEntity;
import tech.devinhouse.labmedical.exceptions.IllegalBirthdayException;
import tech.devinhouse.labmedical.exceptions.NoSuchAddressException;
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

    public PatientResponse register(PatientRequest request) {
        validateBirthday(request);
        validateAddress(request);

        PatientEntity newPatient = mapper.map(request);

        return mapper.map(repository.save(newPatient));
    }

    @SneakyThrows
    private void validateBirthday(PatientRequest request) {
        SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyy");
        String birthday = request.getBirthday();
        Date birthdate = formatter.parse(birthday);
        if (birthdate.after(new Date())) throw new IllegalBirthdayException();
    }

    private void validateAddress(PatientRequest request) throws NoSuchAddressException {
        addressService.findById(request.getAddressId());
    }

    public PatientResponse update(Integer id, PatientRequest request) {
        // ToDo
        return null;
    }

    public List<PatientResponse> findAll() {
        // ToDo
        return null;
    }

    public PatientResponse findById(Integer id) {
        // ToDo
        return null;
    }

    public void deleteById(Integer id) {
        // ToDo
    }
}

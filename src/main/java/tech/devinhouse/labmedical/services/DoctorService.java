package tech.devinhouse.labmedical.services;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;
import tech.devinhouse.labmedical.dtos.DoctorPostRequest;
import tech.devinhouse.labmedical.dtos.DoctorPutRequest;
import tech.devinhouse.labmedical.dtos.DoctorResponse;
import tech.devinhouse.labmedical.entities.DoctorEntity;
import tech.devinhouse.labmedical.mappers.DoctorMapper;
import tech.devinhouse.labmedical.repositories.DoctorRepository;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

@Service
public class DoctorService {
    private final DoctorMapper mapper;
    private final DoctorRepository repository;

    public DoctorService(DoctorMapper mapper, DoctorRepository repository) {
        this.mapper = mapper;
        this.repository = repository;
    }

    public DoctorEntity register(DoctorPostRequest request) {
        validateBirthday(request.getBirthday());
        validateUniqueCPF(request.getCpf());

        DoctorEntity newDoctor = mapper.map(request);

        return repository.save(newDoctor);
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

    private void validateUniqueCPF(String cpf) {
        repository.findByCpf(cpf).ifPresent(e -> {throw new ResponseStatusException(
                HttpStatus.CONFLICT, "CPF duplicado");});
    }

    public DoctorResponse update(Integer id, DoctorPutRequest request) {
        validateBirthday(request.getBirthday());

        DoctorEntity oldDoctor = repository.findById(id).orElseThrow(() -> new ResponseStatusException(
                HttpStatus.NOT_FOUND, "Id de médico inválido"));


        DoctorEntity updatedDoctor = mapper.map(request);
        updatedDoctor.setId(oldDoctor.getId());
        updatedDoctor.setCpf(oldDoctor.getCpf());
        updatedDoctor.setRg(oldDoctor.getRg());
        updatedDoctor.setPassword(oldDoctor.getPassword());

        return mapper.map(repository.save(updatedDoctor));
    }

    public DoctorResponse changePassword(Integer id, String password) {
        DoctorEntity doctor = repository.findById(id).orElseThrow(() -> new ResponseStatusException(
                HttpStatus.NOT_FOUND, "Id de médico inexistente"));

        doctor.setPassword(password);

        return mapper.map(repository.save(doctor));
    }

    public DoctorEntity findById(Integer id) {
        return repository.findById(id).orElseThrow((() -> new ResponseStatusException(
                HttpStatus.BAD_REQUEST, "Id de médico inexistente")));
    }
}

package tech.devinhouse.labmedical.services;

import lombok.SneakyThrows;
import org.springframework.stereotype.Service;
import tech.devinhouse.labmedical.dtos.DoctorPostRequest;
import tech.devinhouse.labmedical.dtos.DoctorPutRequest;
import tech.devinhouse.labmedical.dtos.DoctorResponse;
import tech.devinhouse.labmedical.entities.DoctorEntity;
import tech.devinhouse.labmedical.exceptions.DuplicateCpfException;
import tech.devinhouse.labmedical.exceptions.IllegalBirthdayException;
import tech.devinhouse.labmedical.exceptions.ImmutableDocumentException;
import tech.devinhouse.labmedical.exceptions.NoSuchDoctorException;
import tech.devinhouse.labmedical.mappers.DoctorMapper;
import tech.devinhouse.labmedical.repositories.DoctorRepository;

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

    @SneakyThrows
    private void validateBirthday(String birthday) {
        SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyy");
        Date birthdate = formatter.parse(birthday);
        if (birthdate.after(new Date())) throw new IllegalBirthdayException();
    }

    private void validateUniqueCPF(String cpf) {
        repository.findByCpf(cpf).ifPresent(e -> {throw new DuplicateCpfException();});
    }

    public DoctorResponse update(Integer id, DoctorPutRequest request) {
        validateBirthday(request.getBirthday());

        DoctorEntity oldDoctor = repository.findById(id).orElseThrow(NoSuchDoctorException::new);

        if (!request.getCpf().equals(oldDoctor.getCpf()) || !request.getRg().equals(oldDoctor.getRg()))
            throw new ImmutableDocumentException();

        DoctorEntity updatedDoctor = mapper.map(request);
        updatedDoctor.setId(oldDoctor.getId());

        return mapper.map(repository.save(updatedDoctor));
    }

    public DoctorResponse changePassword(Integer id, String password) {
        DoctorEntity doctor = repository.findById(id).orElseThrow(NoSuchDoctorException::new);

        doctor.setPassword(password);

        return mapper.map(repository.save(doctor));
    }
}

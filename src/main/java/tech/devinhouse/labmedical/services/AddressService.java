package tech.devinhouse.labmedical.services;

import org.springframework.stereotype.Service;
import tech.devinhouse.labmedical.dtos.AddressRequest;
import tech.devinhouse.labmedical.dtos.AddressResponse;
import tech.devinhouse.labmedical.entities.AddressEntity;
import tech.devinhouse.labmedical.exceptions.NoSuchAddressException;
import tech.devinhouse.labmedical.mappers.AddressMapper;
import tech.devinhouse.labmedical.repositories.AddressRepository;

import java.util.List;

@Service
public class AddressService {
    private final AddressRepository repository;
    private final AddressMapper mapper;

    public AddressService(AddressRepository repository, AddressMapper mapper) {
        this.repository = repository;
        this.mapper = mapper;
    }

    public AddressResponse register(AddressRequest request) {
        return mapper.map(repository.save(mapper.map(request)));
    }

    public List<AddressResponse> findAll() {
        return mapper.map(repository.findAll());
    }

    public AddressEntity findById(Integer id) {
        return repository.findById(id).orElseThrow(NoSuchAddressException::new);
    }
}

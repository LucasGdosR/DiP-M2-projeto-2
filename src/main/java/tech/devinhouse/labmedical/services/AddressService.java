package tech.devinhouse.labmedical.services;

import org.springframework.stereotype.Service;
import tech.devinhouse.labmedical.dtos.AddressRequest;
import tech.devinhouse.labmedical.dtos.AddressResponse;
import tech.devinhouse.labmedical.entities.AddressEntity;
import tech.devinhouse.labmedical.exceptions.NoSuchAddressException;
import tech.devinhouse.labmedical.repositories.AddressRepository;

import java.util.List;

@Service
public class AddressService {
    private final AddressRepository repository;

    public AddressService(AddressRepository repository) {
        this.repository = repository;
    }

    public AddressResponse register(AddressRequest request) {
        // ToDo
        return null;
    }

    public List<AddressResponse> findAll() {
        // ToDo
        return null;
    }

    public AddressEntity findById(Integer id) {
        return repository.findById(id).orElseThrow(NoSuchAddressException::new);
    }
}

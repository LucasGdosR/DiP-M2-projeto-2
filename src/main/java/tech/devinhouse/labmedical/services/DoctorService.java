package tech.devinhouse.labmedical.services;

import org.springframework.stereotype.Service;
import tech.devinhouse.labmedical.dtos.DoctorRequest;
import tech.devinhouse.labmedical.dtos.DoctorResponse;

@Service
public class DoctorService {
    public DoctorResponse register(DoctorRequest request) {
        // ToDo
        return null;
    }

    public DoctorResponse update(Integer id, DoctorRequest request) {
        // ToDo
        return null;
    }

    public DoctorResponse changePassword(Integer id, String password) {
        // ToDo
        return null;
    }
}

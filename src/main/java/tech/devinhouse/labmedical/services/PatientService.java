package tech.devinhouse.labmedical.services;

import org.springframework.stereotype.Service;
import tech.devinhouse.labmedical.dtos.PatientRequest;
import tech.devinhouse.labmedical.dtos.PatientResponse;

import java.util.List;

@Service
public class PatientService {
    public PatientResponse register(PatientRequest request) {
        // ToDo
        return null;
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

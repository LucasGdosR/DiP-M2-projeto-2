package tech.devinhouse.labmedical.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import tech.devinhouse.labmedical.entities.AppointmentEntity;
import tech.devinhouse.labmedical.entities.PatientEntity;

import java.util.List;

@Repository
public interface AppointmentRepository extends JpaRepository<AppointmentEntity, Integer> {
    List<AppointmentEntity> findByPatient(PatientEntity patient);
}

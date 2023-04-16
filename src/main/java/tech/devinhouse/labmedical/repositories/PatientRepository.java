package tech.devinhouse.labmedical.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import tech.devinhouse.labmedical.entities.PatientEntity;

import java.util.Optional;

@Repository
public interface PatientRepository extends JpaRepository<PatientEntity, Integer> {
    Optional<PatientEntity> findByCpf(String cpf);
}

package tech.devinhouse.labmedical.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import tech.devinhouse.labmedical.entities.DoctorEntity;

import java.util.Optional;

@Repository
public interface DoctorRepository extends JpaRepository<DoctorEntity, Integer> {
    Optional<DoctorEntity> findByCpf(String cpf);
}

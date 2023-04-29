package tech.devinhouse.labmedical.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import tech.devinhouse.labmedical.entities.ExamEntity;
import tech.devinhouse.labmedical.entities.PatientEntity;

import java.util.List;

@Repository
public interface ExamRepository extends JpaRepository<ExamEntity, Integer> {
    List<ExamEntity> findByPatient(PatientEntity patient);
}

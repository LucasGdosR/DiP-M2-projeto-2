package tech.devinhouse.labmedical.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import tech.devinhouse.labmedical.entities.ExamEntity;

@Repository
public interface ExamRepository extends JpaRepository<ExamEntity, Integer> {
}

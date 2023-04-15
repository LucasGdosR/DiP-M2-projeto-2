package tech.devinhouse.labmedical.mappers;

import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;
import tech.devinhouse.labmedical.dtos.ExamRequest;
import tech.devinhouse.labmedical.dtos.ExamResponse;
import tech.devinhouse.labmedical.entities.ExamEntity;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface ExamMapper {
    ExamEntity map(ExamRequest source);
    ExamResponse map(ExamEntity source);
}

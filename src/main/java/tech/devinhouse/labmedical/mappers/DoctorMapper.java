package tech.devinhouse.labmedical.mappers;

import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;
import tech.devinhouse.labmedical.dtos.DoctorRequest;
import tech.devinhouse.labmedical.dtos.DoctorResponse;
import tech.devinhouse.labmedical.entities.DoctorEntity;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface DoctorMapper {
    DoctorEntity map(DoctorRequest source);
    DoctorResponse map(DoctorEntity source);
}

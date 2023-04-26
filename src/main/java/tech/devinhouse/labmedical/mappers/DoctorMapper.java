package tech.devinhouse.labmedical.mappers;

import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;
import org.springframework.stereotype.Component;
import tech.devinhouse.labmedical.dtos.DoctorPostRequest;
import tech.devinhouse.labmedical.dtos.DoctorPutRequest;
import tech.devinhouse.labmedical.dtos.DoctorResponse;
import tech.devinhouse.labmedical.entities.DoctorEntity;

@Component
@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface DoctorMapper {
    DoctorEntity map(DoctorPostRequest source);
    DoctorEntity map(DoctorPutRequest source);
    DoctorResponse map(DoctorEntity source);

}

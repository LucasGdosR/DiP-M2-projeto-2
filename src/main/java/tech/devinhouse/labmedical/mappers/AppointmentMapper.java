package tech.devinhouse.labmedical.mappers;

import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;
import tech.devinhouse.labmedical.dtos.AppointmentRequest;
import tech.devinhouse.labmedical.dtos.AppointmentResponse;
import tech.devinhouse.labmedical.entities.AppointmentEntity;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface AppointmentMapper {
    AppointmentEntity map(AppointmentRequest source);
    AppointmentResponse map(AppointmentEntity source);
}

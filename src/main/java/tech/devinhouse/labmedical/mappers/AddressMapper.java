package tech.devinhouse.labmedical.mappers;

import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;
import tech.devinhouse.labmedical.dtos.AddressRequest;
import tech.devinhouse.labmedical.dtos.AddressResponse;
import tech.devinhouse.labmedical.entities.AddressEntity;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface AddressMapper {
    AddressEntity map(AddressRequest source);
    AddressResponse map(AddressEntity source);
}

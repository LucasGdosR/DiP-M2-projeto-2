package tech.devinhouse.labmedical.mappers;

import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;
import org.springframework.stereotype.Component;
import tech.devinhouse.labmedical.dtos.AddressRequest;
import tech.devinhouse.labmedical.dtos.AddressResponse;
import tech.devinhouse.labmedical.entities.AddressEntity;

import java.util.List;

@Component
@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface AddressMapper {
    AddressEntity map(AddressRequest source);
    AddressResponse map(AddressEntity source);

    List<AddressResponse> map(List<AddressEntity> source);
}

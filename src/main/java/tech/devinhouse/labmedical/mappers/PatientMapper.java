package tech.devinhouse.labmedical.mappers;

import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;
import org.springframework.stereotype.Component;
import tech.devinhouse.labmedical.dtos.PatientPostRequest;
import tech.devinhouse.labmedical.dtos.PatientPutRequest;
import tech.devinhouse.labmedical.dtos.PatientResponse;
import tech.devinhouse.labmedical.entities.PatientEntity;

import java.util.List;

@Component
@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface PatientMapper {
//    @Mapping(target = "birthday", dateFormat = "dd-MM-yyyy")
    PatientEntity map(PatientPostRequest source);
    PatientResponse map(PatientEntity source);
    //    @Mapping(target = "birthday", dateFormat = "dd-MM-yyyy")
    PatientEntity map(PatientPutRequest request);

    List<PatientResponse> map(List<PatientEntity> byName);
}

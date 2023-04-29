package tech.devinhouse.labmedical.mappers;

import java.time.format.DateTimeFormatter;
import org.springframework.stereotype.Component;
import tech.devinhouse.labmedical.dtos.ExamRequest;
import tech.devinhouse.labmedical.dtos.ExamResponse;
import tech.devinhouse.labmedical.entities.ExamEntity;
import tech.devinhouse.labmedical.services.DoctorService;
import tech.devinhouse.labmedical.services.PatientService;

/*
@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2023-04-28T12:32:18-0300",
    comments = "version: 1.5.3.Final, compiler: javac, environment: Java 18.0.2.1 (Oracle Corporation)"
)
*/
@Component
public class ExamMapper {
    private final DoctorService doctorService;
    private final PatientService patientService;

    public ExamMapper(DoctorService doctorService, PatientService patientService) {
        this.doctorService = doctorService;
        this.patientService = patientService;
    }

    public ExamEntity map(ExamRequest source) {
        if ( source == null ) {
            return null;
        }

        ExamEntity examEntity = new ExamEntity();

        examEntity.setName( source.getName() );
        examEntity.setType( source.getType() );
        examEntity.setLaboratory( source.getLaboratory() );
        examEntity.setFileUrl( source.getFileUrl() );
        examEntity.setResults( source.getResults() );
        examEntity.setDoctor(doctorService.findById(source.getDoctorId()));
        examEntity.setPatient(patientService.findEntityById(source.getPatientId()));

        return examEntity;
    }

    public ExamResponse map(ExamEntity source) {
        if ( source == null ) {
            return null;
        }

        ExamResponse examResponse = new ExamResponse();

        examResponse.setName( source.getName() );
        examResponse.setDateTime( DateTimeFormatter.ISO_LOCAL_DATE_TIME.format( source.getDateTime() ) );
        examResponse.setType( source.getType() );
        examResponse.setLaboratory( source.getLaboratory() );
        examResponse.setFileUrl( source.getFileUrl() );
        examResponse.setResults( source.getResults() );
        examResponse.setDoctorId(source.getDoctor().getId());
        examResponse.setPatientId(source.getPatient().getId());

        return examResponse;
    }
}

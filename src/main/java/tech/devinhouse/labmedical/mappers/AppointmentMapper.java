package tech.devinhouse.labmedical.mappers;

import java.time.format.DateTimeFormatter;
import org.springframework.stereotype.Component;
import tech.devinhouse.labmedical.dtos.AppointmentRequest;
import tech.devinhouse.labmedical.dtos.AppointmentResponse;
import tech.devinhouse.labmedical.entities.AppointmentEntity;
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
public class AppointmentMapper {
    private final DoctorService doctorService;
    private final PatientService patientService;

    public AppointmentMapper(DoctorService doctorService, PatientService patientService) {
        this.doctorService = doctorService;
        this.patientService = patientService;
    }

    public AppointmentEntity map(AppointmentRequest source) {
        if ( source == null ) {
            return null;
        }

        AppointmentEntity appointmentEntity = new AppointmentEntity();

        appointmentEntity.setMotive( source.getMotive() );
        appointmentEntity.setIssueDescription( source.getIssueDescription() );
        appointmentEntity.setPrescribedMedication( source.getPrescribedMedication() );
        appointmentEntity.setDosageAndPrecautions( source.getDosageAndPrecautions() );
        appointmentEntity.setDoctor(doctorService.findById(source.getDoctorId()));
        appointmentEntity.setPatient(patientService.findEntityById(source.getPatientId()));

        return appointmentEntity;
    }

    public AppointmentResponse map(AppointmentEntity source) {
        if ( source == null ) {
            return null;
        }

        AppointmentResponse appointmentResponse = new AppointmentResponse();

        appointmentResponse.setMotive( source.getMotive() );
        appointmentResponse.setDateTime( DateTimeFormatter.ISO_LOCAL_DATE_TIME.format( source.getDateTime() ) );
        appointmentResponse.setIssueDescription( source.getIssueDescription() );
        appointmentResponse.setPrescribedMedication( source.getPrescribedMedication() );
        appointmentResponse.setDosageAndPrecautions( source.getDosageAndPrecautions() );
        appointmentResponse.setDoctorId(source.getDoctor().getId());
        appointmentResponse.setPatientId(source.getPatient().getId());

        return appointmentResponse;
    }
}

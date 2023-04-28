package tech.devinhouse.labmedical.mappers;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ResponseStatusException;
import tech.devinhouse.labmedical.dtos.PatientPostRequest;
import tech.devinhouse.labmedical.dtos.PatientPutRequest;
import tech.devinhouse.labmedical.dtos.PatientResponse;
import tech.devinhouse.labmedical.entities.AppointmentEntity;
import tech.devinhouse.labmedical.entities.ExamEntity;
import tech.devinhouse.labmedical.entities.PatientEntity;

/*
@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2023-04-28T12:32:18-0300",
    comments = "version: 1.5.3.Final, compiler: javac, environment: Java 18.0.2.1 (Oracle Corporation)"
)
*/
@Component
public class PatientMapper {

    public PatientEntity map(PatientPostRequest source) {
        if ( source == null ) {
            return null;
        }

        PatientEntity patientEntity = new PatientEntity();

        patientEntity.setFullName( source.getFullName() );
        patientEntity.setGender( source.getGender() );
        try {
            SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
            patientEntity.setBirthday( dateFormat.parse( source.getBirthday() ) );
            if (source.getInsuranceExpirationDate() != null)
                patientEntity.setInsuranceExpirationDate( dateFormat.parse( source.getInsuranceExpirationDate() ) );
        }
        catch ( ParseException e ) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Validade do convênio no formato errado. Tente 'dd-MM-yyyy'");
        }
        patientEntity.setCpf( source.getCpf() );
        patientEntity.setRg( source.getRg() );
        patientEntity.setMaritalStatus( source.getMaritalStatus() );
        patientEntity.setTelephone( source.getTelephone() );
        patientEntity.setEmail( source.getEmail() );
        patientEntity.setPlaceOfBirth( source.getPlaceOfBirth() );
        patientEntity.setAllergyList( source.getAllergyList() );
        patientEntity.setSpecialNeeds( source.getSpecialNeeds() );
        patientEntity.setEmergencyContact( source.getEmergencyContact() );
        patientEntity.setInsurance( source.getInsurance() );
        patientEntity.setInsuranceCardId( source.getInsuranceCardId() );

        return patientEntity;
    }

    public PatientResponse map(PatientEntity source) {
        if ( source == null ) {
            return null;
        }

        PatientResponse patientResponse = new PatientResponse();

        patientResponse.setFullName( source.getFullName() );
        patientResponse.setGender( source.getGender() );
        patientResponse.setBirthday( new SimpleDateFormat("dd-MM-yyyy").format( source.getBirthday() ) );
        patientResponse.setCpf( source.getCpf() );
        patientResponse.setRg( source.getRg() );
        patientResponse.setMaritalStatus( source.getMaritalStatus() );
        patientResponse.setTelephone( source.getTelephone() );
        patientResponse.setEmail( source.getEmail() );
        patientResponse.setPlaceOfBirth( source.getPlaceOfBirth() );
        patientResponse.setAllergyList( source.getAllergyList() );
        patientResponse.setSpecialNeeds( source.getSpecialNeeds() );
        patientResponse.setEmergencyContact( source.getEmergencyContact() );
        patientResponse.setInsurance( source.getInsurance() );
        patientResponse.setInsuranceCardId( source.getInsuranceCardId() );
        patientResponse.setAddressId( source.getAddress().getId() );

        if ( source.getInsuranceExpirationDate() != null )
            patientResponse.setInsuranceExpirationDate( new SimpleDateFormat("dd-MM-yyyy").format( source.getInsuranceExpirationDate() ) );

        List<AppointmentEntity> list = source.getAppointments();
        if ( list != null )
            patientResponse.setAppointmentIds(list.stream().map(AppointmentEntity::getId).toList());

        List<ExamEntity> list1 = source.getExams();
        if ( list1 != null )
            patientResponse.setExamIds(list1.stream().map(ExamEntity::getId).toList());

        return patientResponse;
    }

    public PatientEntity map(PatientPutRequest source) {
        if ( source == null ) {
            return null;
        }

        PatientEntity patientEntity = new PatientEntity();

        patientEntity.setFullName( source.getFullName() );
        patientEntity.setGender( source.getGender() );
        try {
            SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
            patientEntity.setBirthday( dateFormat.parse( source.getBirthday() ) );
            if (source.getInsuranceExpirationDate() != null)
                patientEntity.setInsuranceExpirationDate( dateFormat.parse( source.getInsuranceExpirationDate() ) );
        }
        catch ( ParseException e ) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Validade do convênio no formato errado. Tente 'dd-MM-yyyy'");
        }
        patientEntity.setMaritalStatus( source.getMaritalStatus() );
        patientEntity.setTelephone( source.getTelephone() );
        patientEntity.setEmail( source.getEmail() );
        patientEntity.setPlaceOfBirth( source.getPlaceOfBirth() );
        patientEntity.setAllergyList( source.getAllergyList() );
        patientEntity.setSpecialNeeds( source.getSpecialNeeds() );
        patientEntity.setEmergencyContact( source.getEmergencyContact() );
        patientEntity.setInsurance( source.getInsurance() );
        patientEntity.setInsuranceCardId( source.getInsuranceCardId() );

        return patientEntity;
    }

    public List<PatientResponse> map(List<PatientEntity> patientEntities) {
        if ( patientEntities == null ) {
            return null;
        }

        List<PatientResponse> list = new ArrayList<>( patientEntities.size() );
        for ( PatientEntity patientEntity : patientEntities ) {
            list.add( map( patientEntity ) );
        }

        return list;
    }
}

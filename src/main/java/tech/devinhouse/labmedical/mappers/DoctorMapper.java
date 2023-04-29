package tech.devinhouse.labmedical.mappers;

import java.text.ParseException;
import java.text.SimpleDateFormat;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ResponseStatusException;
import tech.devinhouse.labmedical.dtos.DoctorPostRequest;
import tech.devinhouse.labmedical.dtos.DoctorPutRequest;
import tech.devinhouse.labmedical.dtos.DoctorResponse;
import tech.devinhouse.labmedical.entities.DoctorEntity;

/*
@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2023-04-28T12:32:18-0300",
    comments = "version: 1.5.3.Final, compiler: javac, environment: Java 18.0.2.1 (Oracle Corporation)"
)
*/
@Component
public class DoctorMapper {

    public DoctorEntity map(DoctorPostRequest source) {
        if ( source == null ) {
            return null;
        }

        DoctorEntity doctorEntity = new DoctorEntity();

        doctorEntity.setFullName( source.getFullName() );
        doctorEntity.setGender( source.getGender() );
        try {
            doctorEntity.setBirthday( new SimpleDateFormat("dd-MM-yyyy").parse( source.getBirthday() ) );
        }
        catch ( ParseException e ) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Idade no formato errado. Tente 'dd-MM-yyyy'");
        }
        doctorEntity.setCpf( source.getCpf() );
        doctorEntity.setRg( source.getRg() );
        doctorEntity.setMaritalStatus( source.getMaritalStatus() );
        doctorEntity.setTelephone( source.getTelephone() );
        doctorEntity.setEmail( source.getEmail() );
        doctorEntity.setPlaceOfBirth( source.getPlaceOfBirth() );
        doctorEntity.setCrm( source.getCrm() );
        doctorEntity.setSpecialization( source.getSpecialization() );
        doctorEntity.setPassword( source.getPassword() );

        return doctorEntity;
    }

    public DoctorEntity map(DoctorPutRequest source) {
        if ( source == null ) {
            return null;
        }

        DoctorEntity doctorEntity = new DoctorEntity();

        doctorEntity.setFullName( source.getFullName() );
        doctorEntity.setGender( source.getGender() );
        try {
            doctorEntity.setBirthday( new SimpleDateFormat("dd-MM-yyyy").parse( source.getBirthday() ) );
        }
        catch ( ParseException e ) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Idade no formato errado. Tente 'dd-MM-yyyy'");
        }
        doctorEntity.setMaritalStatus( source.getMaritalStatus() );
        doctorEntity.setTelephone( source.getTelephone() );
        doctorEntity.setEmail( source.getEmail() );
        doctorEntity.setPlaceOfBirth( source.getPlaceOfBirth() );
        doctorEntity.setCrm( source.getCrm() );
        doctorEntity.setSpecialization( source.getSpecialization() );

        return doctorEntity;
    }

    public DoctorResponse map(DoctorEntity source) {
        if ( source == null ) {
            return null;
        }

        DoctorResponse doctorResponse = new DoctorResponse();

        doctorResponse.setFullName( source.getFullName() );
        doctorResponse.setGender( source.getGender() );
        doctorResponse.setBirthday( new SimpleDateFormat("dd-MM-yyyy").format( source.getBirthday() ) );
        doctorResponse.setCpf( source.getCpf() );
        doctorResponse.setRg( source.getRg() );
        doctorResponse.setMaritalStatus( source.getMaritalStatus() );
        doctorResponse.setTelephone( source.getTelephone() );
        doctorResponse.setEmail( source.getEmail() );
        doctorResponse.setPlaceOfBirth( source.getPlaceOfBirth() );
        doctorResponse.setCrm( source.getCrm() );
        doctorResponse.setSpecialization( source.getSpecialization() );
        doctorResponse.setPassword( source.getPassword() );

        return doctorResponse;
    }
}

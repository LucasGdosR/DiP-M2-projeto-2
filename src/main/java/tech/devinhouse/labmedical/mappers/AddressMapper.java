package tech.devinhouse.labmedical.mappers;

import org.springframework.stereotype.Component;
import tech.devinhouse.labmedical.dtos.AddressRequest;
import tech.devinhouse.labmedical.entities.AddressEntity;

/*
@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2023-04-28T12:32:18-0300",
    comments = "version: 1.5.3.Final, compiler: javac, environment: Java 18.0.2.1 (Oracle Corporation)"
)
*/
@Component
public class AddressMapper {
    public AddressEntity map(AddressRequest source) {
        if ( source == null ) {
            return null;
        }

        AddressEntity addressEntity = new AddressEntity();

        addressEntity.setCep( source.getCep() );
        addressEntity.setCity( source.getCity() );
        addressEntity.setState( source.getState() );
        addressEntity.setStreet( source.getStreet() );
        addressEntity.setNum( source.getNum() );
        addressEntity.setComplement( source.getComplement() );
        addressEntity.setNeighborhood( source.getNeighborhood() );
        addressEntity.setReference( source.getReference() );

        return addressEntity;
    }
}

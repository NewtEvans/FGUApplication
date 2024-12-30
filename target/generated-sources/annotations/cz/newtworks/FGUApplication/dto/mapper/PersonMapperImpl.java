package cz.newtworks.FGUApplication.dto.mapper;

import cz.newtworks.FGUApplication.dto.PersonDTO;
import cz.newtworks.FGUApplication.entity.PersonEntity;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-12-30T15:36:35+0100",
    comments = "version: 1.6.3, compiler: javac, environment: Java 23.0.1 (Oracle Corporation)"
)
@Component
public class PersonMapperImpl implements PersonMapper {

    @Override
    public PersonDTO toDTO(PersonEntity source) {
        if ( source == null ) {
            return null;
        }

        PersonDTO personDTO = new PersonDTO();

        return personDTO;
    }

    @Override
    public PersonEntity toEntity(PersonDTO source) {
        if ( source == null ) {
            return null;
        }

        PersonEntity personEntity = new PersonEntity();

        return personEntity;
    }
}

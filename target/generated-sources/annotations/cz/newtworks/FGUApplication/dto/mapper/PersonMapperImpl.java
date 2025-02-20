package cz.newtworks.FGUApplication.dto.mapper;

import cz.newtworks.FGUApplication.dto.PersonDTO;
import cz.newtworks.FGUApplication.entity.DepartmentEntity;
import cz.newtworks.FGUApplication.entity.PersonEntity;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2025-02-20T13:09:01+0100",
    comments = "version: 1.6.3, compiler: javac, environment: Java 23.0.2 (Oracle Corporation)"
)
@Component
public class PersonMapperImpl implements PersonMapper {

    @Override
    public PersonEntity toEntity(PersonDTO source) {
        if ( source == null ) {
            return null;
        }

        PersonEntity personEntity = new PersonEntity();

        if ( source.getPersonId() != null ) {
            personEntity.setPersonId( source.getPersonId() );
        }
        personEntity.setTitleBeforeName( source.getTitleBeforeName() );
        personEntity.setName( source.getName() );
        personEntity.setSurname( source.getSurname() );
        personEntity.setTitleAfterName( source.getTitleAfterName() );
        personEntity.setStudent( source.getStudent() );
        List<DepartmentEntity> list = source.getDepartments();
        if ( list != null ) {
            personEntity.setDepartments( new ArrayList<DepartmentEntity>( list ) );
        }

        return personEntity;
    }

    @Override
    public PersonDTO toDTO(PersonEntity source) {
        if ( source == null ) {
            return null;
        }

        PersonDTO personDTO = new PersonDTO();

        personDTO.setPersonId( source.getPersonId() );
        personDTO.setTitleBeforeName( source.getTitleBeforeName() );
        personDTO.setName( source.getName() );
        personDTO.setSurname( source.getSurname() );
        personDTO.setTitleAfterName( source.getTitleAfterName() );
        personDTO.setStudent( source.getStudent() );
        List<DepartmentEntity> list = source.getDepartments();
        if ( list != null ) {
            personDTO.setDepartments( new ArrayList<DepartmentEntity>( list ) );
        }

        return personDTO;
    }
}

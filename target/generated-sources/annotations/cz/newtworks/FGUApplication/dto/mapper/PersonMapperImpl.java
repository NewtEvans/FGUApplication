package cz.newtworks.FGUApplication.dto.mapper;

import cz.newtworks.FGUApplication.dto.department.DepartmentDTO;
import cz.newtworks.FGUApplication.dto.person.PersonDTO;
import cz.newtworks.FGUApplication.dto.person.PersonReturnDTO;
import cz.newtworks.FGUApplication.entity.DepartmentEntity;
import cz.newtworks.FGUApplication.entity.PersonEntity;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2025-03-18T16:10:04+0100",
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

        if ( source.getId() != null ) {
            personEntity.setId( source.getId() );
        }
        personEntity.setTitleBeforeName( source.getTitleBeforeName() );
        personEntity.setName( source.getName() );
        personEntity.setSurname( source.getSurname() );
        personEntity.setTitleAfterName( source.getTitleAfterName() );
        personEntity.setRole( source.getRole() );
        personEntity.setDepartments( departmentDTOListToDepartmentEntityList( source.getDepartments() ) );

        return personEntity;
    }

    @Override
    public PersonDTO toDTO(PersonEntity source) {
        if ( source == null ) {
            return null;
        }

        PersonDTO personDTO = new PersonDTO();

        personDTO.setId( source.getId() );
        personDTO.setTitleBeforeName( source.getTitleBeforeName() );
        personDTO.setName( source.getName() );
        personDTO.setSurname( source.getSurname() );
        personDTO.setTitleAfterName( source.getTitleAfterName() );
        personDTO.setRole( source.getRole() );
        personDTO.setDepartments( departmentEntityListToDepartmentDTOList( source.getDepartments() ) );

        return personDTO;
    }

    @Override
    public PersonReturnDTO toReturnDTO(PersonEntity source) {
        if ( source == null ) {
            return null;
        }

        PersonReturnDTO personReturnDTO = new PersonReturnDTO();

        personReturnDTO.setId( source.getId() );
        personReturnDTO.setTitleBeforeName( source.getTitleBeforeName() );
        personReturnDTO.setName( source.getName() );
        personReturnDTO.setSurname( source.getSurname() );
        personReturnDTO.setTitleAfterName( source.getTitleAfterName() );
        personReturnDTO.setRole( source.getRole() );

        return personReturnDTO;
    }

    protected List<PersonEntity> personDTOListToPersonEntityList(List<PersonDTO> list) {
        if ( list == null ) {
            return null;
        }

        List<PersonEntity> list1 = new ArrayList<PersonEntity>( list.size() );
        for ( PersonDTO personDTO : list ) {
            list1.add( toEntity( personDTO ) );
        }

        return list1;
    }

    protected DepartmentEntity departmentDTOToDepartmentEntity(DepartmentDTO departmentDTO) {
        if ( departmentDTO == null ) {
            return null;
        }

        DepartmentEntity departmentEntity = new DepartmentEntity();

        departmentEntity.setId( departmentDTO.getId() );
        departmentEntity.setDepartmentNumber( departmentDTO.getDepartmentNumber() );
        departmentEntity.setDepartmentName( departmentDTO.getDepartmentName() );
        departmentEntity.setPeople( personDTOListToPersonEntityList( departmentDTO.getPeople() ) );

        return departmentEntity;
    }

    protected List<DepartmentEntity> departmentDTOListToDepartmentEntityList(List<DepartmentDTO> list) {
        if ( list == null ) {
            return null;
        }

        List<DepartmentEntity> list1 = new ArrayList<DepartmentEntity>( list.size() );
        for ( DepartmentDTO departmentDTO : list ) {
            list1.add( departmentDTOToDepartmentEntity( departmentDTO ) );
        }

        return list1;
    }

    protected List<PersonDTO> personEntityListToPersonDTOList(List<PersonEntity> list) {
        if ( list == null ) {
            return null;
        }

        List<PersonDTO> list1 = new ArrayList<PersonDTO>( list.size() );
        for ( PersonEntity personEntity : list ) {
            list1.add( toDTO( personEntity ) );
        }

        return list1;
    }

    protected DepartmentDTO departmentEntityToDepartmentDTO(DepartmentEntity departmentEntity) {
        if ( departmentEntity == null ) {
            return null;
        }

        DepartmentDTO departmentDTO = new DepartmentDTO();

        departmentDTO.setId( departmentEntity.getId() );
        departmentDTO.setDepartmentNumber( departmentEntity.getDepartmentNumber() );
        departmentDTO.setDepartmentName( departmentEntity.getDepartmentName() );
        departmentDTO.setPeople( personEntityListToPersonDTOList( departmentEntity.getPeople() ) );

        return departmentDTO;
    }

    protected List<DepartmentDTO> departmentEntityListToDepartmentDTOList(List<DepartmentEntity> list) {
        if ( list == null ) {
            return null;
        }

        List<DepartmentDTO> list1 = new ArrayList<DepartmentDTO>( list.size() );
        for ( DepartmentEntity departmentEntity : list ) {
            list1.add( departmentEntityToDepartmentDTO( departmentEntity ) );
        }

        return list1;
    }
}

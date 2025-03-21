package cz.newtworks.FGUApplication.dto.mapper;

import cz.newtworks.FGUApplication.dto.department.DepartmentDTO;
import cz.newtworks.FGUApplication.dto.department.DepartmentReturnDTO;
import cz.newtworks.FGUApplication.dto.person.PersonDTO;
import cz.newtworks.FGUApplication.entity.DepartmentEntity;
import cz.newtworks.FGUApplication.entity.PersonEntity;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2025-03-21T11:33:08+0100",
    comments = "version: 1.6.3, compiler: javac, environment: Java 23.0.2 (Oracle Corporation)"
)
@Component
public class DepartmentMapperImpl implements DepartmentMapper {

    @Override
    public DepartmentEntity toEntity(DepartmentDTO source) {
        if ( source == null ) {
            return null;
        }

        DepartmentEntity departmentEntity = new DepartmentEntity();

        departmentEntity.setId( source.getId() );
        departmentEntity.setDepartmentNumber( source.getDepartmentNumber() );
        departmentEntity.setDepartmentName( source.getDepartmentName() );
        departmentEntity.setPeople( personDTOListToPersonEntityList( source.getPeople() ) );

        return departmentEntity;
    }

    @Override
    public DepartmentDTO toDTO(DepartmentEntity source) {
        if ( source == null ) {
            return null;
        }

        DepartmentDTO departmentDTO = new DepartmentDTO();

        departmentDTO.setId( source.getId() );
        departmentDTO.setDepartmentNumber( source.getDepartmentNumber() );
        departmentDTO.setDepartmentName( source.getDepartmentName() );
        departmentDTO.setPeople( personEntityListToPersonDTOList( source.getPeople() ) );

        return departmentDTO;
    }

    @Override
    public DepartmentReturnDTO toReturnDTO(DepartmentEntity source) {
        if ( source == null ) {
            return null;
        }

        DepartmentReturnDTO departmentReturnDTO = new DepartmentReturnDTO();

        departmentReturnDTO.setId( source.getId() );
        departmentReturnDTO.setDepartmentNumber( source.getDepartmentNumber() );
        departmentReturnDTO.setDepartmentName( source.getDepartmentName() );

        return departmentReturnDTO;
    }

    protected List<DepartmentEntity> departmentDTOListToDepartmentEntityList(List<DepartmentDTO> list) {
        if ( list == null ) {
            return null;
        }

        List<DepartmentEntity> list1 = new ArrayList<DepartmentEntity>( list.size() );
        for ( DepartmentDTO departmentDTO : list ) {
            list1.add( toEntity( departmentDTO ) );
        }

        return list1;
    }

    protected PersonEntity personDTOToPersonEntity(PersonDTO personDTO) {
        if ( personDTO == null ) {
            return null;
        }

        PersonEntity personEntity = new PersonEntity();

        if ( personDTO.getId() != null ) {
            personEntity.setId( personDTO.getId() );
        }
        personEntity.setTitleBeforeName( personDTO.getTitleBeforeName() );
        personEntity.setName( personDTO.getName() );
        personEntity.setSurname( personDTO.getSurname() );
        personEntity.setTitleAfterName( personDTO.getTitleAfterName() );
        personEntity.setRole( personDTO.getRole() );
        personEntity.setDepartments( departmentDTOListToDepartmentEntityList( personDTO.getDepartments() ) );

        return personEntity;
    }

    protected List<PersonEntity> personDTOListToPersonEntityList(List<PersonDTO> list) {
        if ( list == null ) {
            return null;
        }

        List<PersonEntity> list1 = new ArrayList<PersonEntity>( list.size() );
        for ( PersonDTO personDTO : list ) {
            list1.add( personDTOToPersonEntity( personDTO ) );
        }

        return list1;
    }

    protected List<DepartmentDTO> departmentEntityListToDepartmentDTOList(List<DepartmentEntity> list) {
        if ( list == null ) {
            return null;
        }

        List<DepartmentDTO> list1 = new ArrayList<DepartmentDTO>( list.size() );
        for ( DepartmentEntity departmentEntity : list ) {
            list1.add( toDTO( departmentEntity ) );
        }

        return list1;
    }

    protected PersonDTO personEntityToPersonDTO(PersonEntity personEntity) {
        if ( personEntity == null ) {
            return null;
        }

        PersonDTO personDTO = new PersonDTO();

        personDTO.setId( personEntity.getId() );
        personDTO.setTitleBeforeName( personEntity.getTitleBeforeName() );
        personDTO.setName( personEntity.getName() );
        personDTO.setSurname( personEntity.getSurname() );
        personDTO.setTitleAfterName( personEntity.getTitleAfterName() );
        personDTO.setRole( personEntity.getRole() );
        personDTO.setDepartments( departmentEntityListToDepartmentDTOList( personEntity.getDepartments() ) );

        return personDTO;
    }

    protected List<PersonDTO> personEntityListToPersonDTOList(List<PersonEntity> list) {
        if ( list == null ) {
            return null;
        }

        List<PersonDTO> list1 = new ArrayList<PersonDTO>( list.size() );
        for ( PersonEntity personEntity : list ) {
            list1.add( personEntityToPersonDTO( personEntity ) );
        }

        return list1;
    }
}

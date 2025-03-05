package cz.newtworks.FGUApplication.dto.mapper;

import cz.newtworks.FGUApplication.dto.DepartmentDTO;
import cz.newtworks.FGUApplication.dto.PersonDTO;
import cz.newtworks.FGUApplication.entity.DepartmentEntity;
import cz.newtworks.FGUApplication.entity.PersonEntity;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2025-03-05T08:52:47+0100",
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

    protected DepartmentEntity departmentDTOToDepartmentEntity(DepartmentDTO departmentDTO) {
        if ( departmentDTO == null ) {
            return null;
        }

        DepartmentEntity departmentEntity = new DepartmentEntity();

        departmentEntity.setId( departmentDTO.getId() );
        departmentEntity.setDepartmentNumber( departmentDTO.getDepartmentNumber() );
        departmentEntity.setDepartmentName( departmentDTO.getDepartmentName() );

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

    protected DepartmentDTO departmentEntityToDepartmentDTO(DepartmentEntity departmentEntity) {
        if ( departmentEntity == null ) {
            return null;
        }

        DepartmentDTO departmentDTO = new DepartmentDTO();

        departmentDTO.setId( departmentEntity.getId() );
        departmentDTO.setDepartmentNumber( departmentEntity.getDepartmentNumber() );
        departmentDTO.setDepartmentName( departmentEntity.getDepartmentName() );

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

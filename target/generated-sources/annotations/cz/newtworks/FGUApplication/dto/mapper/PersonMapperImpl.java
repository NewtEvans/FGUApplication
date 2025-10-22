package cz.newtworks.FGUApplication.dto.mapper;

import cz.newtworks.FGUApplication.dto.DepartmentDTO;
import cz.newtworks.FGUApplication.dto.PersonDTO;
import cz.newtworks.FGUApplication.dto.special.PersonNameSurnameDTO;
import cz.newtworks.FGUApplication.entity.DepartmentEntity;
import cz.newtworks.FGUApplication.entity.PersonEntity;
import java.util.LinkedHashSet;
import java.util.Set;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2025-10-22T10:15:19+0200",
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

        personEntity.setDepartments( departmentDTOSetToDepartmentEntitySet( source.getDepartments() ) );
        if ( source.getId() != null ) {
            personEntity.setId( source.getId() );
        }
        personEntity.setTitleBeforeName( source.getTitleBeforeName() );
        personEntity.setFirstName( source.getFirstName() );
        personEntity.setSurname( source.getSurname() );
        personEntity.setTitleAfterName( source.getTitleAfterName() );
        personEntity.setArchived( source.isArchived() );
        personEntity.setIsEmployee( source.getIsEmployee() );

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
        personDTO.setFirstName( source.getFirstName() );
        personDTO.setSurname( source.getSurname() );
        personDTO.setTitleAfterName( source.getTitleAfterName() );
        personDTO.setIsEmployee( source.getIsEmployee() );
        personDTO.setArchived( source.isArchived() );
        personDTO.setDepartments( departmentEntitySetToDepartmentDTOSet( source.getDepartments() ) );

        return personDTO;
    }

    @Override
    public PersonNameSurnameDTO toNameSurnameDTO(PersonEntity source) {
        if ( source == null ) {
            return null;
        }

        PersonNameSurnameDTO personNameSurnameDTO = new PersonNameSurnameDTO();

        personNameSurnameDTO.setId( source.getId() );
        personNameSurnameDTO.setFirstName( source.getFirstName() );
        personNameSurnameDTO.setSurname( source.getSurname() );

        return personNameSurnameDTO;
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

    protected Set<DepartmentEntity> departmentDTOSetToDepartmentEntitySet(Set<DepartmentDTO> set) {
        if ( set == null ) {
            return null;
        }

        Set<DepartmentEntity> set1 = LinkedHashSet.newLinkedHashSet( set.size() );
        for ( DepartmentDTO departmentDTO : set ) {
            set1.add( departmentDTOToDepartmentEntity( departmentDTO ) );
        }

        return set1;
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

    protected Set<DepartmentDTO> departmentEntitySetToDepartmentDTOSet(Set<DepartmentEntity> set) {
        if ( set == null ) {
            return null;
        }

        Set<DepartmentDTO> set1 = LinkedHashSet.newLinkedHashSet( set.size() );
        for ( DepartmentEntity departmentEntity : set ) {
            set1.add( departmentEntityToDepartmentDTO( departmentEntity ) );
        }

        return set1;
    }
}

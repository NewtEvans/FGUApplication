package cz.newtworks.FGUApplication.dto.mapper;

import cz.newtworks.FGUApplication.dto.department.DepartmentDTO;
import cz.newtworks.FGUApplication.dto.person.PersonDTO;
import cz.newtworks.FGUApplication.entity.DepartmentEntity;
import cz.newtworks.FGUApplication.entity.PersonEntity;
import java.util.LinkedHashSet;
import java.util.Set;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2025-04-29T10:54:04+0200",
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
        personEntity.setDepartments( departmentDTOSetToDepartmentEntitySet( source.getDepartments() ) );

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
        personDTO.setDepartments( departmentEntitySetToDepartmentDTOSet( source.getDepartments() ) );

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

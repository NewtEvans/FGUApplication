package cz.newtworks.FGUApplication.dto.mapper;

import cz.newtworks.FGUApplication.dto.CouncilDTO;
import cz.newtworks.FGUApplication.dto.DepartmentDTO;
import cz.newtworks.FGUApplication.dto.FacultyDTO;
import cz.newtworks.FGUApplication.dto.PersonDTO;
import cz.newtworks.FGUApplication.dto.ThesisDTO;
import cz.newtworks.FGUApplication.entity.CouncilEntity;
import cz.newtworks.FGUApplication.entity.DepartmentEntity;
import cz.newtworks.FGUApplication.entity.FacultyEntity;
import cz.newtworks.FGUApplication.entity.PersonEntity;
import cz.newtworks.FGUApplication.entity.ThesisEntity;
import java.util.LinkedHashSet;
import java.util.Set;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2025-12-03T12:34:18+0100",
    comments = "version: 1.6.3, compiler: javac, environment: Java 23.0.2 (Oracle Corporation)"
)
@Component
public class ThesisMapperImpl implements ThesisMapper {

    @Override
    public ThesisDTO toDTO(ThesisEntity source) {
        if ( source == null ) {
            return null;
        }

        ThesisDTO thesisDTO = new ThesisDTO();

        thesisDTO.setId( source.getId() );
        thesisDTO.setThesisType( source.getThesisType() );
        thesisDTO.setStartDate( source.getStartDate() );
        thesisDTO.setNameCz( source.getNameCz() );
        thesisDTO.setNameEn( source.getNameEn() );
        thesisDTO.setStudent( personEntityToPersonDTO( source.getStudent() ) );
        thesisDTO.setTrainer( personEntityToPersonDTO( source.getTrainer() ) );
        thesisDTO.setConsultant( personEntityToPersonDTO( source.getConsultant() ) );
        thesisDTO.setFaculty( facultyEntityToFacultyDTO( source.getFaculty() ) );
        thesisDTO.setCouncil( councilEntityToCouncilDTO( source.getCouncil() ) );
        thesisDTO.setEndDate( source.getEndDate() );
        thesisDTO.setNote( source.getNote() );
        thesisDTO.setThesisStatus( source.getThesisStatus() );

        return thesisDTO;
    }

    @Override
    public ThesisEntity toEntity(ThesisDTO source) {
        if ( source == null ) {
            return null;
        }

        ThesisEntity thesisEntity = new ThesisEntity();

        if ( source.getId() != null ) {
            thesisEntity.setId( source.getId() );
        }
        thesisEntity.setThesisType( source.getThesisType() );
        thesisEntity.setStartDate( source.getStartDate() );
        thesisEntity.setNameCz( source.getNameCz() );
        thesisEntity.setNameEn( source.getNameEn() );
        thesisEntity.setStudent( personDTOToPersonEntity( source.getStudent() ) );
        thesisEntity.setTrainer( personDTOToPersonEntity( source.getTrainer() ) );
        thesisEntity.setConsultant( personDTOToPersonEntity( source.getConsultant() ) );
        thesisEntity.setFaculty( facultyDTOToFacultyEntity( source.getFaculty() ) );
        thesisEntity.setCouncil( councilDTOToCouncilEntity( source.getCouncil() ) );
        thesisEntity.setEndDate( source.getEndDate() );
        thesisEntity.setNote( source.getNote() );
        thesisEntity.setThesisStatus( source.getThesisStatus() );

        return thesisEntity;
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

    protected PersonDTO personEntityToPersonDTO(PersonEntity personEntity) {
        if ( personEntity == null ) {
            return null;
        }

        PersonDTO personDTO = new PersonDTO();

        personDTO.setId( personEntity.getId() );
        personDTO.setTitleBeforeName( personEntity.getTitleBeforeName() );
        personDTO.setFirstName( personEntity.getFirstName() );
        personDTO.setSurname( personEntity.getSurname() );
        personDTO.setTitleAfterName( personEntity.getTitleAfterName() );
        personDTO.setIsEmployee( personEntity.getIsEmployee() );
        personDTO.setArchived( personEntity.isArchived() );
        personDTO.setIsForeign( personEntity.getIsForeign() );
        personDTO.setDepartments( departmentEntitySetToDepartmentDTOSet( personEntity.getDepartments() ) );

        return personDTO;
    }

    protected FacultyDTO facultyEntityToFacultyDTO(FacultyEntity facultyEntity) {
        if ( facultyEntity == null ) {
            return null;
        }

        FacultyDTO facultyDTO = new FacultyDTO();

        facultyDTO.setId( facultyEntity.getId() );
        facultyDTO.setFacultyName( facultyEntity.getFacultyName() );
        facultyDTO.setFacultyAbbreviation( facultyEntity.getFacultyAbbreviation() );
        facultyDTO.setSchool( facultyEntity.getSchool() );

        return facultyDTO;
    }

    protected CouncilDTO councilEntityToCouncilDTO(CouncilEntity councilEntity) {
        if ( councilEntity == null ) {
            return null;
        }

        CouncilDTO councilDTO = new CouncilDTO();

        councilDTO.setId( councilEntity.getId() );
        councilDTO.setCouncilName( councilEntity.getCouncilName() );
        councilDTO.setCouncilAbbreviation( councilEntity.getCouncilAbbreviation() );
        councilDTO.setCouncilNumber( councilEntity.getCouncilNumber() );

        return councilDTO;
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

    protected PersonEntity personDTOToPersonEntity(PersonDTO personDTO) {
        if ( personDTO == null ) {
            return null;
        }

        PersonEntity personEntity = new PersonEntity();

        personEntity.setDepartments( departmentDTOSetToDepartmentEntitySet( personDTO.getDepartments() ) );
        if ( personDTO.getId() != null ) {
            personEntity.setId( personDTO.getId() );
        }
        personEntity.setTitleBeforeName( personDTO.getTitleBeforeName() );
        personEntity.setFirstName( personDTO.getFirstName() );
        personEntity.setSurname( personDTO.getSurname() );
        personEntity.setTitleAfterName( personDTO.getTitleAfterName() );
        personEntity.setArchived( personDTO.isArchived() );
        personEntity.setIsForeign( personDTO.getIsForeign() );
        personEntity.setIsEmployee( personDTO.getIsEmployee() );

        return personEntity;
    }

    protected FacultyEntity facultyDTOToFacultyEntity(FacultyDTO facultyDTO) {
        if ( facultyDTO == null ) {
            return null;
        }

        FacultyEntity facultyEntity = new FacultyEntity();

        if ( facultyDTO.getId() != null ) {
            facultyEntity.setId( facultyDTO.getId() );
        }
        facultyEntity.setFacultyName( facultyDTO.getFacultyName() );
        facultyEntity.setFacultyAbbreviation( facultyDTO.getFacultyAbbreviation() );
        facultyEntity.setSchool( facultyDTO.getSchool() );

        return facultyEntity;
    }

    protected CouncilEntity councilDTOToCouncilEntity(CouncilDTO councilDTO) {
        if ( councilDTO == null ) {
            return null;
        }

        CouncilEntity councilEntity = new CouncilEntity();

        if ( councilDTO.getId() != null ) {
            councilEntity.setId( councilDTO.getId() );
        }
        councilEntity.setCouncilName( councilDTO.getCouncilName() );
        councilEntity.setCouncilAbbreviation( councilDTO.getCouncilAbbreviation() );
        councilEntity.setCouncilNumber( councilDTO.getCouncilNumber() );

        return councilEntity;
    }
}

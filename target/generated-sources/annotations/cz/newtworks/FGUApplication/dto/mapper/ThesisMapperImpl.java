package cz.newtworks.FGUApplication.dto.mapper;

import cz.newtworks.FGUApplication.dto.CouncilDTO;
import cz.newtworks.FGUApplication.dto.FacultyDTO;
import cz.newtworks.FGUApplication.dto.ThesisDTO;
import cz.newtworks.FGUApplication.dto.person.PersonDTO;
import cz.newtworks.FGUApplication.entity.CouncilEntity;
import cz.newtworks.FGUApplication.entity.FacultyEntity;
import cz.newtworks.FGUApplication.entity.PersonEntity;
import cz.newtworks.FGUApplication.entity.ThesisEntity;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2025-03-25T13:59:35+0100",
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

        return thesisDTO;
    }

    @Override
    public ThesisEntity toEntity(ThesisDTO source) {
        if ( source == null ) {
            return null;
        }

        ThesisEntity thesisEntity = new ThesisEntity();

        thesisEntity.setId( source.getId() );
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

        return thesisEntity;
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

        return personEntity;
    }

    protected FacultyEntity facultyDTOToFacultyEntity(FacultyDTO facultyDTO) {
        if ( facultyDTO == null ) {
            return null;
        }

        FacultyEntity facultyEntity = new FacultyEntity();

        facultyEntity.setId( facultyDTO.getId() );
        facultyEntity.setFacultyName( facultyDTO.getFacultyName() );
        facultyEntity.setFacultyAbbreviation( facultyDTO.getFacultyAbbreviation() );

        return facultyEntity;
    }

    protected CouncilEntity councilDTOToCouncilEntity(CouncilDTO councilDTO) {
        if ( councilDTO == null ) {
            return null;
        }

        CouncilEntity councilEntity = new CouncilEntity();

        councilEntity.setId( councilDTO.getId() );
        councilEntity.setCouncilName( councilDTO.getCouncilName() );
        councilEntity.setCouncilAbbreviation( councilDTO.getCouncilAbbreviation() );
        councilEntity.setCouncilNumber( councilDTO.getCouncilNumber() );

        return councilEntity;
    }
}

package cz.newtworks.FGUApplication.dto.mapper;

import cz.newtworks.FGUApplication.dto.CouncilDTO;
import cz.newtworks.FGUApplication.dto.FacultyDTO;
import cz.newtworks.FGUApplication.dto.ThesisDTO;
import cz.newtworks.FGUApplication.entity.CouncilEntity;
import cz.newtworks.FGUApplication.entity.FacultyEntity;
import cz.newtworks.FGUApplication.entity.ThesisEntity;
import java.util.LinkedHashSet;
import java.util.Set;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2025-03-21T13:04:12+0100",
    comments = "version: 1.6.3, compiler: javac, environment: Java 23.0.2 (Oracle Corporation)"
)
@Component
public class FacultyMapperImpl implements FacultyMapper {

    @Override
    public FacultyEntity toEntity(FacultyDTO source) {
        if ( source == null ) {
            return null;
        }

        FacultyEntity facultyEntity = new FacultyEntity();

        facultyEntity.setId( source.getId() );
        facultyEntity.setFacultyName( source.getFacultyName() );
        facultyEntity.setFacultyAbbreviation( source.getFacultyAbbreviation() );
        facultyEntity.setTheses( thesisDTOSetToThesisEntitySet( source.getTheses() ) );

        return facultyEntity;
    }

    @Override
    public FacultyDTO toDTO(FacultyEntity source) {
        if ( source == null ) {
            return null;
        }

        FacultyDTO facultyDTO = new FacultyDTO();

        facultyDTO.setId( source.getId() );
        facultyDTO.setFacultyName( source.getFacultyName() );
        facultyDTO.setFacultyAbbreviation( source.getFacultyAbbreviation() );
        facultyDTO.setTheses( thesisEntitySetToThesisDTOSet( source.getTheses() ) );

        return facultyDTO;
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

    protected ThesisEntity thesisDTOToThesisEntity(ThesisDTO thesisDTO) {
        if ( thesisDTO == null ) {
            return null;
        }

        ThesisEntity thesisEntity = new ThesisEntity();

        thesisEntity.setId( thesisDTO.getId() );
        thesisEntity.setStartDate( thesisDTO.getStartDate() );
        thesisEntity.setNameCz( thesisDTO.getNameCz() );
        thesisEntity.setNameEn( thesisDTO.getNameEn() );
        thesisEntity.setFaculty( toEntity( thesisDTO.getFaculty() ) );
        thesisEntity.setCouncil( councilDTOToCouncilEntity( thesisDTO.getCouncil() ) );
        thesisEntity.setEndDate( thesisDTO.getEndDate() );
        thesisEntity.setNote( thesisDTO.getNote() );

        return thesisEntity;
    }

    protected Set<ThesisEntity> thesisDTOSetToThesisEntitySet(Set<ThesisDTO> set) {
        if ( set == null ) {
            return null;
        }

        Set<ThesisEntity> set1 = LinkedHashSet.newLinkedHashSet( set.size() );
        for ( ThesisDTO thesisDTO : set ) {
            set1.add( thesisDTOToThesisEntity( thesisDTO ) );
        }

        return set1;
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

    protected ThesisDTO thesisEntityToThesisDTO(ThesisEntity thesisEntity) {
        if ( thesisEntity == null ) {
            return null;
        }

        ThesisDTO thesisDTO = new ThesisDTO();

        thesisDTO.setId( thesisEntity.getId() );
        thesisDTO.setStartDate( thesisEntity.getStartDate() );
        thesisDTO.setNameCz( thesisEntity.getNameCz() );
        thesisDTO.setNameEn( thesisEntity.getNameEn() );
        thesisDTO.setFaculty( toDTO( thesisEntity.getFaculty() ) );
        thesisDTO.setCouncil( councilEntityToCouncilDTO( thesisEntity.getCouncil() ) );
        thesisDTO.setEndDate( thesisEntity.getEndDate() );
        thesisDTO.setNote( thesisEntity.getNote() );

        return thesisDTO;
    }

    protected Set<ThesisDTO> thesisEntitySetToThesisDTOSet(Set<ThesisEntity> set) {
        if ( set == null ) {
            return null;
        }

        Set<ThesisDTO> set1 = LinkedHashSet.newLinkedHashSet( set.size() );
        for ( ThesisEntity thesisEntity : set ) {
            set1.add( thesisEntityToThesisDTO( thesisEntity ) );
        }

        return set1;
    }
}

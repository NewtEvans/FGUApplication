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
    date = "2025-03-21T13:04:13+0100",
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
        thesisEntity.setFaculty( facultyDTOToFacultyEntity( source.getFaculty() ) );
        thesisEntity.setCouncil( councilDTOToCouncilEntity( source.getCouncil() ) );
        thesisEntity.setEndDate( source.getEndDate() );
        thesisEntity.setNote( source.getNote() );

        return thesisEntity;
    }

    protected Set<ThesisDTO> thesisEntitySetToThesisDTOSet(Set<ThesisEntity> set) {
        if ( set == null ) {
            return null;
        }

        Set<ThesisDTO> set1 = LinkedHashSet.newLinkedHashSet( set.size() );
        for ( ThesisEntity thesisEntity : set ) {
            set1.add( toDTO( thesisEntity ) );
        }

        return set1;
    }

    protected FacultyDTO facultyEntityToFacultyDTO(FacultyEntity facultyEntity) {
        if ( facultyEntity == null ) {
            return null;
        }

        FacultyDTO facultyDTO = new FacultyDTO();

        facultyDTO.setId( facultyEntity.getId() );
        facultyDTO.setFacultyName( facultyEntity.getFacultyName() );
        facultyDTO.setFacultyAbbreviation( facultyEntity.getFacultyAbbreviation() );
        facultyDTO.setTheses( thesisEntitySetToThesisDTOSet( facultyEntity.getTheses() ) );

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

    protected Set<ThesisEntity> thesisDTOSetToThesisEntitySet(Set<ThesisDTO> set) {
        if ( set == null ) {
            return null;
        }

        Set<ThesisEntity> set1 = LinkedHashSet.newLinkedHashSet( set.size() );
        for ( ThesisDTO thesisDTO : set ) {
            set1.add( toEntity( thesisDTO ) );
        }

        return set1;
    }

    protected FacultyEntity facultyDTOToFacultyEntity(FacultyDTO facultyDTO) {
        if ( facultyDTO == null ) {
            return null;
        }

        FacultyEntity facultyEntity = new FacultyEntity();

        facultyEntity.setId( facultyDTO.getId() );
        facultyEntity.setFacultyName( facultyDTO.getFacultyName() );
        facultyEntity.setFacultyAbbreviation( facultyDTO.getFacultyAbbreviation() );
        facultyEntity.setTheses( thesisDTOSetToThesisEntitySet( facultyDTO.getTheses() ) );

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

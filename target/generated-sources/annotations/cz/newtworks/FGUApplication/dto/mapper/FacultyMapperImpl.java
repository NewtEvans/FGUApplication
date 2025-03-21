package cz.newtworks.FGUApplication.dto.mapper;

import cz.newtworks.FGUApplication.dto.FacultyDTO;
import cz.newtworks.FGUApplication.entity.FacultyEntity;
import cz.newtworks.FGUApplication.entity.ThesisEntity;
import java.util.LinkedHashSet;
import java.util.Set;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2025-03-21T11:33:08+0100",
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
        Set<ThesisEntity> set = source.getTheses();
        if ( set != null ) {
            facultyEntity.setTheses( new LinkedHashSet<ThesisEntity>( set ) );
        }

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
        Set<ThesisEntity> set = source.getTheses();
        if ( set != null ) {
            facultyDTO.setTheses( new LinkedHashSet<ThesisEntity>( set ) );
        }

        return facultyDTO;
    }
}

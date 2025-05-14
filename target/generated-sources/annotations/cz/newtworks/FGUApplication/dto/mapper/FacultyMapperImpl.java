package cz.newtworks.FGUApplication.dto.mapper;

import cz.newtworks.FGUApplication.dto.FacultyDTO;
import cz.newtworks.FGUApplication.entity.FacultyEntity;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2025-05-13T12:24:54+0200",
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
        facultyEntity.setSchool( source.getSchool() );

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
        facultyDTO.setSchool( source.getSchool() );

        return facultyDTO;
    }
}

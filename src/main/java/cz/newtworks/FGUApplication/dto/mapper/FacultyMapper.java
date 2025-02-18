package cz.newtworks.FGUApplication.dto.mapper;

import cz.newtworks.FGUApplication.dto.FacultyDTO;
import cz.newtworks.FGUApplication.entity.FacultyEntity;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface FacultyMapper {
    FacultyEntity toEntity(FacultyDTO source);
    FacultyDTO toDTO(FacultyEntity source);
}

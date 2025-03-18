package cz.newtworks.FGUApplication.dto.mapper;

import cz.newtworks.FGUApplication.dto.ThesisDTO;
import cz.newtworks.FGUApplication.entity.ThesisEntity;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ThesisMapper {

    ThesisDTO toDTO(ThesisEntity source);

    ThesisEntity toEntity(ThesisDTO source);

}

package cz.newtworks.FGUApplication.dto.mapper;

import cz.newtworks.FGUApplication.dto.person.PersonDTO;
import cz.newtworks.FGUApplication.dto.person.PersonReturnDTO;
import cz.newtworks.FGUApplication.entity.PersonEntity;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface PersonMapper {
    PersonEntity toEntity(PersonDTO source);
    PersonDTO toDTO(PersonEntity source);
    PersonReturnDTO toReturnDTO(PersonEntity source);
}

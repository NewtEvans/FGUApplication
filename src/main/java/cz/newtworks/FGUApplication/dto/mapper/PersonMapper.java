package cz.newtworks.FGUApplication.dto.mapper;

import cz.newtworks.FGUApplication.dto.PersonDTO;
import cz.newtworks.FGUApplication.dto.special.PersonNameSurnameDTO;
import cz.newtworks.FGUApplication.entity.PersonEntity;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface PersonMapper {
    PersonEntity toEntity(PersonDTO source);

    PersonDTO toDTO(PersonEntity source);

    PersonNameSurnameDTO toNameSurnameDTO(PersonEntity source);
}

package cz.newtworks.FGUApplication.dto.mapper;

import cz.newtworks.FGUApplication.dto.CouncilDTO;
import cz.newtworks.FGUApplication.dto.special.CouncilNameOnlyDTO;
import cz.newtworks.FGUApplication.entity.CouncilEntity;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface CouncilMapper {
    CouncilEntity toEntity(CouncilDTO source);

    CouncilDTO toDTO(CouncilEntity source);

    CouncilNameOnlyDTO toNameOnlyDTO(CouncilEntity source);
}

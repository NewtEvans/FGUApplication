package cz.newtworks.FGUApplication.dto.mapper;

import cz.newtworks.FGUApplication.dto.CouncilDTO;
import cz.newtworks.FGUApplication.entity.CouncilEntity;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2025-03-17T10:43:12+0100",
    comments = "version: 1.6.3, compiler: javac, environment: Java 23.0.2 (Oracle Corporation)"
)
@Component
public class CouncilMapperImpl implements CouncilMapper {

    @Override
    public CouncilEntity toEntity(CouncilDTO source) {
        if ( source == null ) {
            return null;
        }

        CouncilEntity councilEntity = new CouncilEntity();

        councilEntity.setId( source.getId() );
        councilEntity.setCouncilName( source.getCouncilName() );
        councilEntity.setCouncilAbbreviation( source.getCouncilAbbreviation() );
        councilEntity.setCouncilNumber( source.getCouncilNumber() );

        return councilEntity;
    }

    @Override
    public CouncilDTO toDTO(CouncilEntity source) {
        if ( source == null ) {
            return null;
        }

        CouncilDTO councilDTO = new CouncilDTO();

        councilDTO.setId( source.getId() );
        councilDTO.setCouncilName( source.getCouncilName() );
        councilDTO.setCouncilAbbreviation( source.getCouncilAbbreviation() );
        councilDTO.setCouncilNumber( source.getCouncilNumber() );

        return councilDTO;
    }
}

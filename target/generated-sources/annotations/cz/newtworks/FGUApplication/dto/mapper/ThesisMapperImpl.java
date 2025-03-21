package cz.newtworks.FGUApplication.dto.mapper;

import cz.newtworks.FGUApplication.dto.ThesisDTO;
import cz.newtworks.FGUApplication.entity.ThesisEntity;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2025-03-21T11:33:08+0100",
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
        thesisDTO.setCouncil( source.getCouncil() );
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
        thesisEntity.setCouncil( source.getCouncil() );
        thesisEntity.setEndDate( source.getEndDate() );
        thesisEntity.setNote( source.getNote() );

        return thesisEntity;
    }
}

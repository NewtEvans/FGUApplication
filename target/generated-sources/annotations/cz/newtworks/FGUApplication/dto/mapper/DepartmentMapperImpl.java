package cz.newtworks.FGUApplication.dto.mapper;

import cz.newtworks.FGUApplication.dto.DepartmentDTO;
import cz.newtworks.FGUApplication.entity.DepartmentEntity;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2025-12-03T12:34:18+0100",
    comments = "version: 1.6.3, compiler: javac, environment: Java 23.0.2 (Oracle Corporation)"
)
@Component
public class DepartmentMapperImpl implements DepartmentMapper {

    @Override
    public DepartmentEntity toEntity(DepartmentDTO source) {
        if ( source == null ) {
            return null;
        }

        DepartmentEntity departmentEntity = new DepartmentEntity();

        departmentEntity.setId( source.getId() );
        departmentEntity.setDepartmentNumber( source.getDepartmentNumber() );
        departmentEntity.setDepartmentName( source.getDepartmentName() );

        return departmentEntity;
    }

    @Override
    public DepartmentDTO toDTO(DepartmentEntity source) {
        if ( source == null ) {
            return null;
        }

        DepartmentDTO departmentDTO = new DepartmentDTO();

        departmentDTO.setId( source.getId() );
        departmentDTO.setDepartmentNumber( source.getDepartmentNumber() );
        departmentDTO.setDepartmentName( source.getDepartmentName() );

        return departmentDTO;
    }
}

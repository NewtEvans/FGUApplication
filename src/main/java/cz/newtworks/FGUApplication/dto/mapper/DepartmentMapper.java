package cz.newtworks.FGUApplication.dto.mapper;

import cz.newtworks.FGUApplication.dto.department.DepartmentDTO;
import cz.newtworks.FGUApplication.dto.department.DepartmentReturnDTO;
import cz.newtworks.FGUApplication.entity.DepartmentEntity;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface DepartmentMapper {
    DepartmentEntity toEntity(DepartmentDTO source);
    DepartmentDTO toDTO(DepartmentEntity source);
    DepartmentReturnDTO toReturnDTO(DepartmentEntity source);
}

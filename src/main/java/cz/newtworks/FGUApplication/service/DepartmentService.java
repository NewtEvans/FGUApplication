package cz.newtworks.FGUApplication.service;

import cz.newtworks.FGUApplication.dto.DepartmentDTO;

import java.util.List;

public interface DepartmentService {

    DepartmentDTO addDepartment(DepartmentDTO departmentDTO);

    List<DepartmentDTO> getAllDepartments();
}

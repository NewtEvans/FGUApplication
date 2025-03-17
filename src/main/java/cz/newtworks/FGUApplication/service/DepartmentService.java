package cz.newtworks.FGUApplication.service;

import cz.newtworks.FGUApplication.dto.department.DepartmentDTO;
import cz.newtworks.FGUApplication.dto.department.DepartmentReturnDTO;

import java.util.List;

public interface DepartmentService {

    /**
     * Method creates a new department.
     * @param departmentDTO
     * @return DTO with freshly created department
     */
    DepartmentDTO addDepartment(DepartmentDTO departmentDTO);

    /**
     * Method returns all departments in the database.
     * @return List with DTO of all department from the database
     */
    List<DepartmentReturnDTO> getAllDepartments();

    /**
     * Method edits already created department.
     * @param departmentDTO new department data
     * @param departmentId id of edited department
     * @return DTO with edited department
     */
    DepartmentDTO editDepartment(DepartmentDTO departmentDTO, long departmentId);

    void deleteDepartment(long departmentId);
}

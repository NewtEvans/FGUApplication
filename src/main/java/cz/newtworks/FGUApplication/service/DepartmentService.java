package cz.newtworks.FGUApplication.service;

import cz.newtworks.FGUApplication.dto.department.DepartmentDTO;
import cz.newtworks.FGUApplication.dto.person.PersonDTO;

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
    List<DepartmentDTO> getAllDepartments();

    /**
     * Method returns details of department with requested id.
     * @param departmentId Requested id
     * @return DTO with detail of department with requested id
     */
    DepartmentDTO departmentDetail(long departmentId);

    /**
     * Method edits already created department.
     * @param departmentDTO new department data
     * @param departmentId id of edited department
     * @return DTO with edited department
     */
    DepartmentDTO editDepartment(DepartmentDTO departmentDTO, long departmentId);

    /**
     * Method deletes department with specific ID.
     * @param departmentId deleted department id
     */
    void deleteDepartment(long departmentId);
}

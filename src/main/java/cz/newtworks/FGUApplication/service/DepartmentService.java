package cz.newtworks.FGUApplication.service;

import cz.newtworks.FGUApplication.dto.DepartmentDTO;
import cz.newtworks.FGUApplication.dto.filter.DepartmentFilterDTO;
import cz.newtworks.FGUApplication.exception.ResourceNotFoundException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface DepartmentService {

    /**
     * Method creates a new department.
     *
     * @param departmentDTO
     * @return DTO with freshly created department
     */
    DepartmentDTO createDepartment(DepartmentDTO departmentDTO);

    /**
     * Method allows to create multiple departments into the database.
     *
     * @param departmentDTOs
     */
    void createMultipleDepartments(List<DepartmentDTO> departmentDTOs);

    /**
     * Method returns all departments in the database.
     * Contains pagination and specification components.
     *
     * @return List with DTO of all department from the database
     */
    Page<DepartmentDTO> getAllDepartments(Pageable pageable, DepartmentFilterDTO departmentFilterDTO);

    /**
     * Method returns number of all departments in the database.
     *
     * @return int with number
     */
    int countDepartments();

    /**
     * Method returns details of department with requested id.
     *
     * @param departmentId Requested id
     * @return DTO with detail of department with requested id
     * @throws ResourceNotFoundException if department with requested id doesn't exist
     */
    DepartmentDTO getDepartmentById(long departmentId) throws ResourceNotFoundException;

    /**
     * Method edits already created department.
     *
     * @param departmentDTO new department data
     * @param departmentId  id of edited department
     * @return DTO with edited department
     */
    DepartmentDTO editDepartment(DepartmentDTO departmentDTO, long departmentId);

    /**
     * Method deletes department with specific ID.
     *
     * @param departmentId deleted department id
     */
    void deleteDepartment(long departmentId);

}

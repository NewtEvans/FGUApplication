package cz.newtworks.FGUApplication.service;

import cz.newtworks.FGUApplication.dto.DepartmentDTO;
import cz.newtworks.FGUApplication.dto.filter.DepartmentFilterDTO;
import cz.newtworks.FGUApplication.dto.mapper.DepartmentMapper;
import cz.newtworks.FGUApplication.entity.DepartmentEntity;
import cz.newtworks.FGUApplication.entity.repository.DepartmentRepository;
import cz.newtworks.FGUApplication.exception.ResourceNotFoundException;
import cz.newtworks.FGUApplication.specification.DepartmentSpecification;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class DepartmentServiceImpl implements DepartmentService {

    @Autowired
    private DepartmentMapper departmentMapper;

    @Autowired
    private DepartmentRepository departmentRepository;

    @Override
    public DepartmentDTO addDepartment(DepartmentDTO departmentDTO) {
        DepartmentEntity newDepartment = departmentMapper.toEntity(departmentDTO);
        departmentRepository.save(newDepartment);

        return departmentMapper.toDTO(newDepartment);
    }

    @Override
    public List<DepartmentDTO> addDepartments(List<DepartmentDTO> departmentDTOs) {
        List<DepartmentEntity> departmentEntities = departmentDTOs.stream()
                .map(departmentDTO -> departmentMapper.toEntity(departmentDTO))
                .collect(Collectors.toList());

        departmentRepository.saveAll(departmentEntities);

        return null;
    }

    @Override
    public Page<DepartmentDTO> getAllDepartments(Pageable pageable, DepartmentFilterDTO departmentFilterDTO) {
        Specification<DepartmentEntity> specification = DepartmentSpecification.buildSpecification(departmentFilterDTO);

        return departmentRepository.findAll(specification, pageable)
                .map(departmentMapper::toDTO);
    }

    @Override
    public int getNumberOfAllDepartments() {
        return departmentRepository.countAllDepartments();
    }

    @Override
    public DepartmentDTO getDepartmentById(long departmentId) {
        return departmentMapper.toDTO(fetchDepartmentById(departmentId));
    }

    @Override
    public DepartmentDTO editDepartment(DepartmentDTO departmentDTO, long departmentId) {
        DepartmentEntity newDepartment = departmentMapper.toEntity(departmentDTO);
        newDepartment.setId(departmentId);
        departmentRepository.save(newDepartment);

        return departmentMapper.toDTO(fetchDepartmentById(departmentId));
    }

    @Override
    public void deleteDepartment(long departmentId) {
        departmentRepository.delete(fetchDepartmentById(departmentId));
    }

    //private methods

    /**
     * Private method that returns entity of department with specific ID.
     * If asked ID doesn't exist method returns error exception.
     *
     * @param departmentId
     * @return Department entity with asked id
     * @throws ResourceNotFoundException if no person with the given ID is found
     */
    private DepartmentEntity fetchDepartmentById(long departmentId) {
        return departmentRepository.findById(departmentId).orElseThrow(() -> new ResourceNotFoundException("Department with id" + departmentId + "wasn't found in the database."));
    }


}

package cz.newtworks.FGUApplication.service;

import cz.newtworks.FGUApplication.dto.DepartmentDTO;
import cz.newtworks.FGUApplication.dto.mapper.DepartmentMapper;
import cz.newtworks.FGUApplication.entity.DepartmentEntity;
import cz.newtworks.FGUApplication.entity.repository.DepartmentRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class DepartmentServiceImpl implements DepartmentService{

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
    public List<DepartmentDTO> getAllDepartments() {
        return departmentRepository.findAll()
                .stream()
                .map(i -> departmentMapper.toDTO(i))
                .collect(Collectors.toList());
    }

    @Override
    public DepartmentDTO editDepartment(DepartmentDTO departmentDTO, long departmentId) {
        DepartmentEntity newDepartment = departmentMapper.toEntity(departmentDTO);

        newDepartment.setId(departmentId);

        departmentRepository.save(newDepartment);

        return departmentMapper.toDTO(newDepartment);
    }

    @Override
    public void deleteDepartment(long departmentId) {
        departmentRepository.delete(fetchDepartmentById(departmentId));
    }

    //private methods
    private DepartmentEntity fetchDepartmentById(long departmentId) {
       return  departmentRepository.findById(departmentId).orElseThrow(() -> new EntityNotFoundException("Department with id" + departmentId + "wasn't found in the database."));
    }


}

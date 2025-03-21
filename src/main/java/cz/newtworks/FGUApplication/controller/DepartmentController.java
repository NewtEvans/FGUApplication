package cz.newtworks.FGUApplication.controller;

import cz.newtworks.FGUApplication.dto.department.DepartmentDTO;
import cz.newtworks.FGUApplication.dto.department.DepartmentReturnDTO;
import cz.newtworks.FGUApplication.service.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/department")
public class DepartmentController {

    @Autowired
    private DepartmentService departmentService;

    @PostMapping("/create")
    public DepartmentDTO addDepartment(@RequestBody DepartmentDTO departmentDTO){
       return departmentService.addDepartment(departmentDTO);
    }

    @GetMapping("")
    public List<DepartmentDTO> getAllDepartment(){
        return departmentService.getAllDepartments();
    }

    @PutMapping("/{departmentId}")
    public DepartmentDTO editDepartment(@RequestBody DepartmentDTO departmentDTO, @PathVariable long departmentId){
        return departmentService.editDepartment(departmentDTO, departmentId);
    }

    @DeleteMapping("/{departmentId}")
    public void deleteDepartment(@PathVariable long departmentId){
        departmentService.deleteDepartment(departmentId);
    }
}

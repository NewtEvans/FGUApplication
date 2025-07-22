package cz.newtworks.FGUApplication.controller;

import cz.newtworks.FGUApplication.dto.DepartmentDTO;
import cz.newtworks.FGUApplication.dto.filter.DepartmentFilterDTO;
import cz.newtworks.FGUApplication.service.DepartmentService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/department")
public class DepartmentController {

    @Autowired
    private DepartmentService departmentService;

    @PostMapping
    public ResponseEntity<DepartmentDTO> createDepartment(@Valid @RequestBody DepartmentDTO departmentDTO) {
        return ResponseEntity.status(HttpStatus.CREATED).body(departmentService.addDepartment(departmentDTO));
    }

    @PostMapping("/multiple")
    public ResponseEntity<?> createDepartments(@RequestBody List<DepartmentDTO> departmentDTOs) {
        departmentService.addDepartments(departmentDTOs);
        return ResponseEntity.ok("OK");
    }

    @GetMapping("/all")
    public ResponseEntity<Page<DepartmentDTO>> getAllDepartment(
            Pageable pageable,
            @ModelAttribute DepartmentFilterDTO departmentFilterDTO) {
        return ResponseEntity.ok(departmentService.getAllDepartments(pageable, departmentFilterDTO));
    }

    @GetMapping("/count")
    public int getNumberOfAllDepartments() {
        return departmentService.getNumberOfAllDepartments();
    }

    @GetMapping("/{departmentId}")
    public ResponseEntity<DepartmentDTO> getDepartment(@PathVariable long departmentId) {
        return ResponseEntity.ok(departmentService.getDepartmentById(departmentId));
    }

    @PutMapping("/{departmentId}")
    public ResponseEntity<DepartmentDTO> updateDepartment(@Valid @RequestBody DepartmentDTO departmentDTO, @PathVariable long departmentId) {
        return ResponseEntity.ok(departmentService.editDepartment(departmentDTO, departmentId));
    }

    @DeleteMapping("/{departmentId}")
    public ResponseEntity<Void> deleteDepartment(@PathVariable long departmentId) {
        departmentService.deleteDepartment(departmentId);
        return ResponseEntity.noContent().build();
    }

}

package cz.newtworks.FGUApplication.controller;

import cz.newtworks.FGUApplication.dto.FacultyDTO;
import cz.newtworks.FGUApplication.dto.filter.FacultyFilterDTO;
import cz.newtworks.FGUApplication.service.FacultyService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/faculty")
public class FacultyController {

    @Autowired
    private FacultyService facultyService;

    @PostMapping
    public ResponseEntity<FacultyDTO> createFaculty(@Valid @RequestBody FacultyDTO facultyDTO) {
        return ResponseEntity.status(HttpStatus.CREATED).body(facultyService.addFaculty(facultyDTO));
    }

    @GetMapping("/all")
    public ResponseEntity<Page<FacultyDTO>> getAllFaculty(
            @ModelAttribute FacultyFilterDTO facultyFilterDTO,
            Pageable pageable) {
        return ResponseEntity.ok(facultyService.getAllFaculty(pageable, facultyFilterDTO));
    }

    @GetMapping("/count")
    public int getNumberOfAllFaculty() {
        return facultyService.getCountOfAllFaculty();
    }

    @GetMapping("/{facultyId}")
    public ResponseEntity<FacultyDTO> getFaculty(@PathVariable long facultyId) {
        return ResponseEntity.ok(facultyService.getFacultyById(facultyId));
    }

    @PutMapping("/{facultyId}")
    public ResponseEntity<FacultyDTO> updateFaculty(@Valid @PathVariable long facultyId, @RequestBody FacultyDTO facultyDTO) {
        return ResponseEntity.ok(facultyService.editFaculty(facultyId, facultyDTO));
    }

    @DeleteMapping("/{facultyId}")
    public ResponseEntity<Void> deleteFaculty(@PathVariable long facultyId) {
        facultyService.deleteFaculty(facultyId);
        return ResponseEntity.noContent().build();
    }
}

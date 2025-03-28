package cz.newtworks.FGUApplication.controller;

import cz.newtworks.FGUApplication.dto.FacultyDTO;
import cz.newtworks.FGUApplication.service.FacultyService;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/faculty")
public class FacultyController {

    @Autowired
    private FacultyService facultyService;

    @PostMapping("/create")
    public FacultyDTO addFaculty(@RequestBody FacultyDTO facultyDTO) {
        return facultyService.addFaculty(facultyDTO);
    }

    @GetMapping("/all")
    public List<FacultyDTO> getAllFaculty() {
        return facultyService.getAllFaculty();
    }

    @GetMapping("/detail/{facultyId}")
    public FacultyDTO facultyDetail(@PathVariable long facultyId) {
        return facultyService.facultyDetail(facultyId);
    }

    @PutMapping("/edit/{facultyId}")
    public FacultyDTO editFaculty(@PathVariable long facultyId, @RequestBody FacultyDTO facultyDTO){
        return facultyService.editFaculty(facultyId, facultyDTO);
    }

    @DeleteMapping("/delete/{facultyId}")
    public void deleteFaculty(@PathVariable long facultyId){
        facultyService.deleteFaculty(facultyId);
    }
}

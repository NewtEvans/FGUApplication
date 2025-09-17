package cz.newtworks.FGUApplication.controller;

import cz.newtworks.FGUApplication.dto.ThesisDTO;
import cz.newtworks.FGUApplication.dto.filter.ThesisFilterDTO;
import cz.newtworks.FGUApplication.service.ThesisService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/thesis")
public class ThesisController {

    @Autowired
    private ThesisService thesisService;

    @PostMapping
    public ResponseEntity<ThesisDTO> createThesis(@Valid @RequestBody ThesisDTO thesisDTO) {
        return ResponseEntity.status(HttpStatus.CREATED).body(thesisService.createThesis(thesisDTO));
    }

    @GetMapping("/all/pageable")
    public ResponseEntity<Page<ThesisDTO>> getAllThesisPageable(
            Pageable pageable,
            @ModelAttribute ThesisFilterDTO thesisFilterDTO) {
        return ResponseEntity.ok(thesisService.getAllThesisPageable(pageable, thesisFilterDTO));
    }

    @GetMapping("/count")
    public ResponseEntity<Long> getThesesCount() {
        return ResponseEntity.ok(thesisService.countTheses());
    }

    @GetMapping("/years")
    public ResponseEntity<List<Integer>> getYears() {
        return ResponseEntity.ok(thesisService.getYears());
    }

    @GetMapping("/{thesisId}")
    public ResponseEntity<ThesisDTO> getThesis(@PathVariable long thesisId) {
        return ResponseEntity.ok(thesisService.getThesisById(thesisId));
    }

    @PutMapping("/{thesisId}")
    public ResponseEntity<ThesisDTO> updateThesis(@Valid @PathVariable long thesisId, @RequestBody ThesisDTO thesisDTO) {
        return ResponseEntity.ok(thesisService.editThesis(thesisId, thesisDTO));
    }

    @DeleteMapping("/{thesisId}")
    public ResponseEntity<Void> deleteThesis(@PathVariable long thesisId) {
        thesisService.deleteThesis(thesisId);

        return ResponseEntity.noContent().build();
    }

    @GetMapping("/consultant/{consultantId}")
    public ResponseEntity<List<ThesisDTO>> getConsultantsTheses(@PathVariable long consultantId) {
        return ResponseEntity.ok(thesisService.getAllThesisWithConsultantId(consultantId));
    }

    @GetMapping("/student/{studentId}")
    public ResponseEntity<List<ThesisDTO>> getStudentTheses(@PathVariable long studentId) {
        return ResponseEntity.ok(thesisService.getAllThesisWithStudentId(studentId));
    }

    @GetMapping("/trainer/{trainerId}")
    public ResponseEntity<List<ThesisDTO>> getTrainerTheses(@PathVariable long trainerId) {
        return ResponseEntity.ok(thesisService.getAllThesisWithTrainerId(trainerId));
    }
}

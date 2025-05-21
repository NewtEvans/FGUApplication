package cz.newtworks.FGUApplication.controller;

import cz.newtworks.FGUApplication.dto.CouncilDTO;
import cz.newtworks.FGUApplication.service.CouncilService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/council")
public class CouncilController {

    @Autowired
    private CouncilService councilService;

    @PostMapping
    public ResponseEntity<CouncilDTO> createCouncil(@Valid @RequestBody CouncilDTO councilDTO) {
        return ResponseEntity.status(HttpStatus.CREATED).body(councilService.addCouncil(councilDTO));
    }

    @GetMapping("/all")
    public ResponseEntity<Page<CouncilDTO>> getAllCouncils(Pageable pageable) {
        return ResponseEntity.ok(councilService.getAllCouncils(pageable));
    }

    @GetMapping("/{councilId}")
    public ResponseEntity<CouncilDTO> getCouncil(@PathVariable long councilId) {
        return ResponseEntity.ok(councilService.getCouncilById(councilId));
    }

    @PutMapping("/{councilId}")
    public ResponseEntity<CouncilDTO> updateCouncil(@PathVariable long councilId, @RequestBody CouncilDTO councilDTO) {
        return ResponseEntity.ok(councilService.editCouncil(councilId, councilDTO));
    }

    @DeleteMapping("/{councilId}")
    public ResponseEntity<Void> deleteCouncil(@PathVariable long councilId) {
        councilService.deleteCouncil(councilId);
        return ResponseEntity.noContent().build();
    }

}

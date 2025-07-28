package cz.newtworks.FGUApplication.controller;

import cz.newtworks.FGUApplication.dto.CouncilDTO;
import cz.newtworks.FGUApplication.dto.filter.CouncilFilterDTO;
import cz.newtworks.FGUApplication.service.CouncilService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/council")
public class CouncilController {

    @Autowired
    private CouncilService councilService;

    @PostMapping
    public ResponseEntity<CouncilDTO> createCouncil(@Valid @RequestBody CouncilDTO councilDTO) {
        return ResponseEntity.status(HttpStatus.CREATED).body(councilService.createCouncil(councilDTO));
    }

    @PostMapping("/multiple")
    public ResponseEntity<?> createMultipleCouncils(@RequestBody List<CouncilDTO> councilDTOs) {
        councilService.createMultipleCouncils(councilDTOs);

        return ResponseEntity.ok("OK");
    }

    @GetMapping("/all")
    public ResponseEntity<Page<CouncilDTO>> getAllCouncils(
            Pageable pageable,
            @ModelAttribute CouncilFilterDTO councilFilterDTO) {
        return ResponseEntity.ok(councilService.getAllCouncils(pageable, councilFilterDTO));
    }

    @GetMapping("/count")
    public ResponseEntity<Integer> getCouncilCount() {
        return ResponseEntity.ok(councilService.countCouncils());
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

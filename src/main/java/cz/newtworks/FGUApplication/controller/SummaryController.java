package cz.newtworks.FGUApplication.controller;

import cz.newtworks.FGUApplication.dto.SummaryDTO;
import cz.newtworks.FGUApplication.entity.repository.ThesisRepository;
import cz.newtworks.FGUApplication.service.SummaryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/summary")
public class SummaryController {


    @Autowired
    private SummaryService summaryService;

    @Autowired
    private ThesisRepository thesisRepository;

    @GetMapping()
    public ResponseEntity<SummaryDTO> getCompleteSummary(@RequestParam int year) {
        return ResponseEntity.ok(summaryService.getCompleteSummary(year));
    }
}

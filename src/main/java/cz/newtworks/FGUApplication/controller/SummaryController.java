package cz.newtworks.FGUApplication.controller;

import cz.newtworks.FGUApplication.entity.repository.ThesisRepository;
import cz.newtworks.FGUApplication.service.ThesisService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;

@RestController
@RequestMapping("/summary")
public class SummaryController {

    @Autowired
    private ThesisRepository thesisRepository;

    @Autowired
    private ThesisService thesisService;

    @GetMapping()
    public int getNumberOfAllTheses(@ModelAttribute LocalDate date) {
        return thesisRepository.findAllThesisByData(date);
    }
}

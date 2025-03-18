package cz.newtworks.FGUApplication.controller;

import cz.newtworks.FGUApplication.dto.ThesisDTO;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/thesis")
public class ThesisController {

    @PostMapping("/create")
    public ThesisDTO addThesis(ThesisDTO thesisDTO){
        return null;
    }
}

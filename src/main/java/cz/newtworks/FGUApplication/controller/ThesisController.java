package cz.newtworks.FGUApplication.controller;

import cz.newtworks.FGUApplication.dto.ThesisDTO;
import cz.newtworks.FGUApplication.service.ThesisService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/thesis")
public class ThesisController {

    @Autowired
     private ThesisService thesisService;

    @PostMapping("/create")
    public ThesisDTO addThesis(@RequestBody ThesisDTO thesisDTO){
        return thesisService.addThesis(thesisDTO);
    }
}

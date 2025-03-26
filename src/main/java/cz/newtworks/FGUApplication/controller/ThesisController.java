package cz.newtworks.FGUApplication.controller;

import cz.newtworks.FGUApplication.dto.ThesisDTO;
import cz.newtworks.FGUApplication.service.ThesisService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/thesis")
public class ThesisController {

    @Autowired
     private ThesisService thesisService;

    @PostMapping("/create")
    public ThesisDTO addThesis(@RequestBody ThesisDTO thesisDTO){
        return thesisService.addThesis(thesisDTO);
    }

    @GetMapping("")
    public List<ThesisDTO> getAllThesis(){
        return thesisService.getAllThesis();
    }

    @GetMapping("{thesisId}")
    public ThesisDTO detailThesis(@PathVariable long thesisId){
        return thesisService.detailThesis(thesisId);
    }

    @PutMapping("{thesisId}")
    public ThesisDTO editThesis(@PathVariable long thesisId, @RequestBody ThesisDTO thesisDTO){
        return thesisService.editThesis(thesisId, thesisDTO);
    }

    @DeleteMapping("{thesisId}")
    public void deleteThesis(@PathVariable long thesisId){
        thesisService.deteleThesis(thesisId);
    }
}

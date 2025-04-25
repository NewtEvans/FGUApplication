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

    @GetMapping("/all")
    public List<ThesisDTO> getAllThesis(){
        return thesisService.getAllThesis();
    }

    @GetMapping("/detail/{thesisId}")
    public ThesisDTO detailThesis(@PathVariable long thesisId){
        return thesisService.detailThesis(thesisId);
    }

    @PutMapping("/edit/{thesisId}")
    public ThesisDTO editThesis(@PathVariable long thesisId, @RequestBody ThesisDTO thesisDTO){
        return thesisService.editThesis(thesisId, thesisDTO);
    }

    @DeleteMapping("/delete/{thesisId}")
    public void deleteThesis(@PathVariable long thesisId){
        thesisService.deleteThesis(thesisId);
    }

    @GetMapping("/consultant/{consultantId}")
    public List<ThesisDTO> getConsultantsTheses(@PathVariable long consultantId){
        return thesisService.getAllThesisWithConsultantId(consultantId);
    }

    @GetMapping("/student/{studentId}")
    public List<ThesisDTO> getStudentTheses(@PathVariable long studentId){
        return thesisService.getAllThesisWithStudentId(studentId);
    }

    @GetMapping("/trainer/{trainerId}")
    public List<ThesisDTO> getTrainerTheses(@PathVariable long trainerId){
        return thesisService.getAllThesisWithTrainerId(trainerId);
    }
}

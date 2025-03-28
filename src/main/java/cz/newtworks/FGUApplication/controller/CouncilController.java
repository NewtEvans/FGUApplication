package cz.newtworks.FGUApplication.controller;

import cz.newtworks.FGUApplication.dto.CouncilDTO;
import cz.newtworks.FGUApplication.service.CouncilService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/council")
public class CouncilController {

    @Autowired
    private CouncilService councilService;

    @PostMapping("/create")
    public CouncilDTO addCouncil(@RequestBody CouncilDTO councilDTO){
        return councilService.addCouncil(councilDTO);
    }

    @GetMapping("/all")
    public List<CouncilDTO> getAllCouncils(){
        return councilService.getAllCouncils();
    }

    @GetMapping("/detail/{councilId}")
    public CouncilDTO councilDetail(@PathVariable long councilId){
        return councilService.councilDetail(councilId);
    }

    @PutMapping("/edit/{councilId}")
    public CouncilDTO editCouncil(@PathVariable long councilId, @RequestBody CouncilDTO councilDTO){
        return councilService.editCouncil(councilId, councilDTO);
    }

    @DeleteMapping("/delete/{councilId}")
    public void deleteCouncil(@PathVariable long councilId){
        councilService.deleteCouncil(councilId);
    }

}

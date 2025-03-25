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

    @PostMapping("")
    public CouncilDTO addCouncil(@RequestBody CouncilDTO councilDTO){
        return councilService.addCouncil(councilDTO);
    }

    @GetMapping("")
    public List<CouncilDTO> getAllCouncils(){
        return councilService.getAllCouncils();
    }

    @GetMapping("{councilId}")
    public CouncilDTO councilDetail(@PathVariable long councilId){
        return councilService.councilDetail(councilId);
    }

    @PutMapping("{councilId}")
    public CouncilDTO editCouncil(@PathVariable long councilId, @RequestBody CouncilDTO councilDTO){
        return councilService.editCouncil(councilId, councilDTO);
    }

    @DeleteMapping("{councilId}")
    public void deleteCouncil(@PathVariable long councilId){
        councilService.delteCouncil(councilId);
    }

}

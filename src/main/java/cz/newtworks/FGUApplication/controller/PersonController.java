package cz.newtworks.FGUApplication.controller;

import cz.newtworks.FGUApplication.dto.PersonDTO;
import cz.newtworks.FGUApplication.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;



@RestController
@RequestMapping("/people")
public class PersonController {

    @Autowired
    private PersonService personService;

    @GetMapping
    public String renderIndex(){
        return "index.html";
    }

    @PostMapping("/create")
    public PersonDTO addPerson(@RequestBody PersonDTO personDTO){
        return personService.addPerson(personDTO);
    }
}

package cz.newtworks.FGUApplication.controller;

import cz.newtworks.FGUApplication.dto.person.PersonDTO;
import cz.newtworks.FGUApplication.dto.person.PersonReturnDTO;
import cz.newtworks.FGUApplication.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/people")
public class PersonController {

    @Autowired
    private PersonService personService;

    @GetMapping
    public List<PersonReturnDTO> getAllPeople() {
        return personService.getAllPeople();
    }

    @GetMapping("/{personId}")
    public PersonReturnDTO personDetail(@PathVariable long personId){
        return personService.personDetail(personId);
    }

    @PostMapping("/create")
    public PersonDTO addPerson(@RequestBody PersonDTO personDTO) {
        return personService.addPerson(personDTO);
    }

    @PutMapping("/{personId}")
    public PersonDTO editPerson(@RequestBody PersonDTO personDTO, @PathVariable long personId){
        return personService.editPerson(personDTO, personId);
    }

    @DeleteMapping("/{personId}")
    public void deletePerson(@PathVariable long personId){
        personService.deletePerson(personId);
    }
}

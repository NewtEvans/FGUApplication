package cz.newtworks.FGUApplication.controller;

import cz.newtworks.FGUApplication.dto.PersonDTO;
import cz.newtworks.FGUApplication.dto.filter.PersonFilterDTO;
import cz.newtworks.FGUApplication.dto.special.PersonNameSurnameDTO;
import cz.newtworks.FGUApplication.service.PersonService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/person")
public class PersonController {

    @Autowired
    private PersonService personService;

    @PostMapping
    public ResponseEntity<PersonDTO> createPerson(@Valid @RequestBody PersonDTO personDTO) {
        return ResponseEntity.status(HttpStatus.CREATED).body(personService.createPerson(personDTO));
    }

    @PostMapping("/multiple")
    public ResponseEntity<?> createMultiplePeople(@RequestBody List<PersonDTO> people) {
        personService.createMultiplePerson(people);

        return ResponseEntity.status(HttpStatus.CREATED).body("OK");
    }

    @GetMapping("/all/pageable")
    public ResponseEntity<Page<PersonDTO>> getAllPeoplePageable(
            Pageable pageable,
            @ModelAttribute PersonFilterDTO personFilterDTO) {
        return ResponseEntity.ok(personService.getAllPeoplePageable(pageable, personFilterDTO));
    }

    @GetMapping("/all")
    public ResponseEntity<List<PersonNameSurnameDTO>> getAllPeople() {
        return ResponseEntity.ok(personService.getAllPeople());
    }

    @GetMapping("/department/{departmentId}")
    public ResponseEntity<List<PersonDTO>> getAllPeopleInDepartment(@PathVariable long departmentId) {
        return ResponseEntity.ok(personService.getAllPeopleInDepartment(departmentId));
    }

    @GetMapping("/count")
    public ResponseEntity<Integer> getPeopleCount() {
        return ResponseEntity.ok(personService.countPeople());
    }

    @GetMapping("/{personId}")
    public ResponseEntity<PersonDTO> getPerson(@PathVariable long personId) {
        return ResponseEntity.ok(personService.getPersonById(personId));
    }

    @PutMapping("/{personId}")
    public ResponseEntity<PersonDTO> updatePerson(@Valid @RequestBody PersonDTO personDTO, @PathVariable long personId) {
        return ResponseEntity.ok(personService.editPerson(personDTO, personId));
    }

    @DeleteMapping("/{personId}")
    public ResponseEntity<Void> deletePerson(@PathVariable long personId) {
        personService.deletePerson(personId);

        return ResponseEntity.noContent().build();
    }

}

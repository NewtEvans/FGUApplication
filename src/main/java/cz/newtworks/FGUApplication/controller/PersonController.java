package cz.newtworks.FGUApplication.controller;
import cz.newtworks.FGUApplication.dto.PersonDTO;
import cz.newtworks.FGUApplication.service.PersonService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
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
        return ResponseEntity.status(HttpStatus.CREATED).body(personService.addPerson(personDTO));
    }

    @GetMapping("/all")
    public ResponseEntity<Page<PersonDTO>> getAllPeople(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size
    ) {
        Pageable pageable = PageRequest.of(page, size);
        return ResponseEntity.ok(personService.getAllPeople(pageable));
    }

    @GetMapping("/{personId}")
    public ResponseEntity<PersonDTO> getPerson(@PathVariable long personId){
        return ResponseEntity.ok(personService.getPersonById(personId));
    }

    @PutMapping("/{personId}")
    public ResponseEntity<PersonDTO> updatePerson(@Valid @RequestBody PersonDTO personDTO, @PathVariable long personId){
        return ResponseEntity.ok(personService.editPerson(personDTO, personId));
    }

    @DeleteMapping("/{personId}")
    public ResponseEntity<Void> deletePerson(@PathVariable long personId){
        personService.deletePerson(personId);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/department/{departmentId}")
    public ResponseEntity<List<PersonDTO>> getAllPeopleInDepartment(@PathVariable long departmentId){
        return ResponseEntity.ok(personService.getAllPeopleInDepartment(departmentId));
    }
}

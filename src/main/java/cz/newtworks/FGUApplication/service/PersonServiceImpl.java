package cz.newtworks.FGUApplication.service;

import cz.newtworks.FGUApplication.dto.PersonDTO;
import cz.newtworks.FGUApplication.dto.mapper.DepartmentMapper;
import cz.newtworks.FGUApplication.dto.mapper.PersonMapper;
import cz.newtworks.FGUApplication.entity.PersonEntity;
import cz.newtworks.FGUApplication.entity.repository.PersonRepository;
import cz.newtworks.FGUApplication.exception.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class PersonServiceImpl implements PersonService{

    @Autowired
    private PersonMapper personMapper;

    @Autowired
    private DepartmentMapper departmentMapper;

    @Autowired
    private PersonRepository personRepository;

    @Override
    public PersonDTO addPerson(PersonDTO personDTO){
        PersonEntity newPersonEntity = personMapper.toEntity(personDTO);
        personRepository.save(newPersonEntity);

        return personMapper.toDTO(newPersonEntity);
    }

    @Override
    public List<PersonDTO> getAllPeople() {
        return personRepository.findAll()
                .stream()
                .map(i -> personMapper.toDTO(i))
                .collect(Collectors.toList());
    }

    @Override
    public List<PersonDTO> getAllPeopleInDepartment(long departmentId) {
        return personRepository.findAllPeopleInDepartment(departmentId)
                .stream()
                .map(person -> personMapper.toDTO(person))
                .collect(Collectors.toList());
    }

    @Override
    public PersonDTO getPersonById(long id) {
        return personMapper.toDTO(fetchPersonById(id));
    }

    @Override
    public PersonDTO editPerson(PersonDTO personDTO, long personId) {
       PersonEntity editedPerson = personMapper.toEntity(personDTO);
       editedPerson.setId(personId);
       personRepository.save(editedPerson);

       return personMapper.toDTO(fetchPersonById(personId));
    }

    @Override
    public void deletePerson(long personId) {
        personRepository.delete(fetchPersonById(personId));
    }

    //Test method
    public Page<PersonDTO> getPaginatedPeople(Pageable pageable){
        return personRepository.findAll(pageable).map(personMapper::toDTO);
    }

    //Private methods

    /**
     * Private method that returns person entity with specific ID.
     * If asked ID doesn't exist method returns error exception.
     * @param id
     * @return Person entity with asked id
     * @throws ResourceNotFoundException if no person with the given ID is found
     */
    private PersonEntity fetchPersonById(long id){
        return personRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Person with ID " + id + " was not found in the database"));
    }
}

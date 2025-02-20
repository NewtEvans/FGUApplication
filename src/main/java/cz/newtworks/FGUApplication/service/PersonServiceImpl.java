package cz.newtworks.FGUApplication.service;

import cz.newtworks.FGUApplication.dto.PersonDTO;
import cz.newtworks.FGUApplication.dto.mapper.PersonMapper;
import cz.newtworks.FGUApplication.entity.DepartmentEntity;
import cz.newtworks.FGUApplication.entity.PersonEntity;
import cz.newtworks.FGUApplication.entity.repository.DepartmentRepository;
import cz.newtworks.FGUApplication.entity.repository.PersonRepository;
import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class PersonServiceImpl implements PersonService{

    @Autowired
    private PersonMapper personMapper;

    @Autowired
    private PersonRepository personRepository;

    @Autowired
    private DepartmentRepository departmentRepository;

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
    @Transactional
    public PersonDTO personDetail(long id) {

        PersonEntity person = fetchPersonById(id);
        for (DepartmentEntity entity : person.getDepartments()){
            DepartmentEntity newEntity = departmentRepository.getReferenceById(entity.getDepartmentId());
            System.out.println(newEntity);
        }

        return personMapper.toDTO(person);

    }

    @Override
    public PersonDTO editPerson(PersonDTO personDTO, long personId) {
       PersonEntity editedPerson = personMapper.toEntity(personDTO);
       editedPerson.setPersonId(personId);
       personRepository.save(editedPerson);

       return personMapper.toDTO(fetchPersonById(personId));
    }

    @Override
    public void deletePerson(long personId) {
        personRepository.delete(fetchPersonById(personId));
    }

    //Private methods
    private PersonEntity fetchPersonById(long id){
        return personRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Person with id" + id + "wasn't found in the database."));
    }
}

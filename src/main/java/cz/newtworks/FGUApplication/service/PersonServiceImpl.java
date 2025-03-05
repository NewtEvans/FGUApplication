package cz.newtworks.FGUApplication.service;

import cz.newtworks.FGUApplication.dto.DepartmentDTO;
import cz.newtworks.FGUApplication.dto.PersonDTO;
import cz.newtworks.FGUApplication.dto.mapper.DepartmentMapper;
import cz.newtworks.FGUApplication.dto.mapper.PersonMapper;
import cz.newtworks.FGUApplication.entity.DepartmentEntity;
import cz.newtworks.FGUApplication.entity.PersonEntity;
import cz.newtworks.FGUApplication.entity.repository.PersonRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.crossstore.ChangeSetPersister;
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
    public PersonDTO personDetail(long id) {
        List<DepartmentEntity> departments = null;

        PersonEntity person = fetchPersonById(id);

        departments = person.getDepartments();

        PersonDTO personDTO = personMapper.toDTO(person);

        List<DepartmentDTO> departmentDTOList = departments
                .stream()
                .map( i -> departmentMapper.toDTO(i))
                .collect(Collectors.toList());

        personDTO.setDepartments(departmentDTOList);

        return personDTO;
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

    //Private methods
    private PersonEntity fetchPersonById(long id){
        return personRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Person with id" + id + "wasn't found in the database."));
    }
}

package cz.newtworks.FGUApplication.service;

import cz.newtworks.FGUApplication.dto.PersonDTO;
import cz.newtworks.FGUApplication.dto.mapper.PersonMapper;
import cz.newtworks.FGUApplication.entity.PersonEntity;
import cz.newtworks.FGUApplication.entity.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PersonServiceImpl implements PersonService{

    @Autowired
    private PersonMapper personMapper;

    @Autowired
    private PersonRepository personRepository;

    @Override
    public PersonDTO addPerson(PersonDTO personDTO){
        PersonEntity personEntity = personMapper.toEntity(personDTO);
        personRepository.save(personEntity);

        return personMapper.toDTO(personEntity);
    }
}

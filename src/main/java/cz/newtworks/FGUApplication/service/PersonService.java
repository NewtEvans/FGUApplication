package cz.newtworks.FGUApplication.service;

import cz.newtworks.FGUApplication.dto.PersonDTO;

import java.util.List;

public interface PersonService {

    /**
     * Method creates a new person into the database.
     * @param personDTO
     * @return DTO with newly created person
     */
    PersonDTO addPerson(PersonDTO personDTO);

    /**
     * Method returns all people in the database.
     * @return List of all people in the database
     */
    List<PersonDTO> getAllPeople();

    PersonDTO personDetail(long id);

    /**
     * Method edits already created person.
     * @param personDTO new person data
     * @param personId id of edited person
     * @return DTO with updated person
     */
    PersonDTO editPerson(PersonDTO personDTO, long personId);

    /**
     * Method deletes person.
     * @param personId id of deleted person
     */
    void deletePerson(long personId);
}

package cz.newtworks.FGUApplication.service;

import cz.newtworks.FGUApplication.dto.PersonDTO;
import cz.newtworks.FGUApplication.dto.filter.PersonFilterDTO;
import cz.newtworks.FGUApplication.exception.ResourceNotFoundException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface PersonService {

    /**
     * Method creates a new person into the database.
     *
     * @param personDTO
     * @return DTO with newly created person
     */
    PersonDTO createPerson(PersonDTO personDTO);

    /**
     * Method allows to create multiple people in the database.
     *
     * @param people
     */
    void createMultiplePerson(List<PersonDTO> people);

    /**
     * Method returns all people in the database.
     * Contains pagination and specification components.
     *
     * @return Page with all people in the database
     */
    Page<PersonDTO> getAllPeople(Pageable pageable, PersonFilterDTO personFilterDTO);


    /**
     * Method returns number of all people in the database.
     *
     * @return int with number
     */
    int countPeople();


    /**
     * Method returns all people in particular department
     *
     * @return List of DTOs with people
     */
    List<PersonDTO> getAllPeopleInDepartment(long departmentId);

    /**
     * Method returns details of person with requested id.
     *
     * @param id Requested id
     * @return DTO with detail of person with requested id
     * @throws ResourceNotFoundException if person with requested id doesn't exist
     */
    PersonDTO getPersonById(long id) throws ResourceNotFoundException;

    /**
     * Method edits already created person.
     *
     * @param personDTO new person data
     * @param personId  id of edited person
     * @return DTO with updated person
     */
    PersonDTO editPerson(PersonDTO personDTO, long personId);

    /**
     * Method deletes person with requested id.
     *
     * @param personId id of deleted person
     */
    void deletePerson(long personId);

}

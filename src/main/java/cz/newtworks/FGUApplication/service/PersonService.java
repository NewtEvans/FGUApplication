package cz.newtworks.FGUApplication.service;

import cz.newtworks.FGUApplication.dto.PersonDTO;
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
    PersonDTO addPerson(PersonDTO personDTO);

    /**
     * Method returns all people in the database.
     * Contains pagination components.
     *
     * @return Page with all people in the database
     */
    Page<PersonDTO> getAllPeople(Pageable pageable);

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

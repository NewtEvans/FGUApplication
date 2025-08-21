package cz.newtworks.FGUApplication.entity.repository;

import cz.newtworks.FGUApplication.dto.special.PersonNameSurnameDTO;
import cz.newtworks.FGUApplication.entity.PersonEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface PersonRepository extends JpaRepository<PersonEntity, Long>, JpaSpecificationExecutor<PersonEntity> {
    @Query("SELECT COUNT(*) FROM PersonEntity")
    int countAllPerson();

    @Query("SELECT p FROM PersonEntity p JOIN p.departments d WHERE d.id = ?1")
    List<PersonEntity> findAllPeopleInDepartment(long departmentId);

    @Query("SELECT new cz.newtworks.FGUApplication.dto.special.PersonNameSurnameDTO(p.id, p.firstName, p.surname) FROM PersonEntity p")
        //constructor expression
    List<PersonNameSurnameDTO> findAllNamesInDatabase();
}

package cz.newtworks.FGUApplication.entity.repository;

import cz.newtworks.FGUApplication.entity.PersonEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PersonRepository extends JpaRepository<PersonEntity, Long> {

}

package cz.newtworks.FGUApplication.entity.repository;

import cz.newtworks.FGUApplication.entity.FacultyEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FacultyRepository extends JpaRepository<FacultyEntity, Long> {
}

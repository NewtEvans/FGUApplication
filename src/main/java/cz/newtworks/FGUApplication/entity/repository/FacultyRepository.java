package cz.newtworks.FGUApplication.entity.repository;

import cz.newtworks.FGUApplication.entity.FacultyEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface FacultyRepository extends JpaRepository<FacultyEntity, Long>, JpaSpecificationExecutor<FacultyEntity> {
}

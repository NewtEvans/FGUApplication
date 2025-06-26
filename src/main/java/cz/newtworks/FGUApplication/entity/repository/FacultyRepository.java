package cz.newtworks.FGUApplication.entity.repository;

import cz.newtworks.FGUApplication.entity.FacultyEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;

public interface FacultyRepository extends JpaRepository<FacultyEntity, Long>, JpaSpecificationExecutor<FacultyEntity> {
    @Query("SELECT COUNT(*) FROM FacultyEntity")
    int countAllFaculty();
}

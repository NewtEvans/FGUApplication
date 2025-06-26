package cz.newtworks.FGUApplication.entity.repository;

import cz.newtworks.FGUApplication.entity.DepartmentEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;

public interface DepartmentRepository extends JpaRepository<DepartmentEntity, Long>, JpaSpecificationExecutor<DepartmentEntity> {
    @Query("SELECT COUNT(*) FROM DepartmentEntity")
    int countAllDepartments();


}

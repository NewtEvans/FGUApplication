package cz.newtworks.FGUApplication.entity.repository;

import cz.newtworks.FGUApplication.entity.DepartmentEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DepartmentRepository extends JpaRepository<DepartmentEntity, Long> {
}

package cz.newtworks.FGUApplication.entity.repository;

import cz.newtworks.FGUApplication.entity.ThesisEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ThesisRepository extends JpaRepository<ThesisEntity, Long> {
}

package cz.newtworks.FGUApplication.entity.repository;

import cz.newtworks.FGUApplication.entity.CouncilEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CouncilRepository extends JpaRepository<CouncilEntity, Long> {
}

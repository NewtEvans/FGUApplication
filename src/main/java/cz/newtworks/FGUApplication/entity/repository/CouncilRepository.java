package cz.newtworks.FGUApplication.entity.repository;

import cz.newtworks.FGUApplication.entity.CouncilEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface CouncilRepository extends JpaRepository<CouncilEntity, Long>, JpaSpecificationExecutor<CouncilEntity> {
}

package cz.newtworks.FGUApplication.entity.repository;

import cz.newtworks.FGUApplication.entity.CouncilEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;

public interface CouncilRepository extends JpaRepository<CouncilEntity, Long>, JpaSpecificationExecutor<CouncilEntity> {
    @Query("SELECT COUNT(*) FROM CouncilEntity")
    int countAllCouncils();
}

package cz.newtworks.FGUApplication.entity.repository;

import cz.newtworks.FGUApplication.entity.ThesisEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ThesisRepository extends JpaRepository<ThesisEntity, Long>, JpaSpecificationExecutor<ThesisEntity> {
    @Query("SELECT t FROM ThesisEntity t WHERE consultant.id = ?1")
    List<ThesisEntity> findAllThesisWithConsultantId(long consultantId);

    @Query("SELECT t FROM ThesisEntity t WHERE student.id = ?1")
    List<ThesisEntity> findAllThesisWithStudentId(long studentId);

    @Query("SELECT t FROM ThesisEntity t WHERE trainer.id = ?1")
    List<ThesisEntity> findAllThesisWithTrainerId(long trainerId);

    @Query("SELECT COUNT(*) FROM ThesisEntity")
    int countAllThesis();
}

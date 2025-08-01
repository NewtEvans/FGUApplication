package cz.newtworks.FGUApplication.entity.repository;

import cz.newtworks.FGUApplication.constant.ThesisType;
import cz.newtworks.FGUApplication.entity.ThesisEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;

import java.time.LocalDate;
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

    @Query("SELECT COUNT(*) FROM ThesisEntity WHERE startDate = ?1")
    int findAllThesisByData(LocalDate date);

    @Query("SELECT COUNT(*) FROM ThesisEntity t WHERE t.startDate BETWEEN :start AND :end")
    int findAllByStartDateBetween(LocalDate start, LocalDate end);

    @Query("SELECT COUNT(*) FROM ThesisEntity t WHERE t.endDate BETWEEN :start AND :end")
    int findAllByEndDateBetween(LocalDate start, LocalDate end);

    @Query("SELECT COUNT(*) FROM ThesisEntity t WHERE t.startDate BETWEEN :start AND :end AND t.thesisType = :type")
    int findNewThesesByStartDateAndThesisType(LocalDate start, LocalDate end, ThesisType type);

    @Query("SELECT COUNT(*) FROM ThesisEntity t WHERE t.endDate BETWEEN :start AND :end AND t.thesisType = :type")
    int findEndedThesesByEndDateAndThesisType(LocalDate start, LocalDate end, ThesisType type);

    @Query("SELECT DISTINCT YEAR(t.endDate) y FROM ThesisEntity t ORDER BY y")
    List<Integer> findYearsInDatabase();
}

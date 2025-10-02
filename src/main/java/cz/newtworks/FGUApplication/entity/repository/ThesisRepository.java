package cz.newtworks.FGUApplication.entity.repository;

import cz.newtworks.FGUApplication.constant.ThesisType;
import cz.newtworks.FGUApplication.entity.ThesisEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;

import java.time.LocalDate;
import java.util.List;

public interface ThesisRepository extends JpaRepository<ThesisEntity, Long>, JpaSpecificationExecutor<ThesisEntity> {

    List<ThesisEntity> findAllByConsultantId(long consultantId);

    List<ThesisEntity> findAllByStudentId(long studentId);

    List<ThesisEntity> findAllByTrainerId(long trainerId);

    long count();

    @Query("SELECT COUNT(*) FROM ThesisEntity WHERE startDate = ?1")
    long countAllThesisByData(LocalDate date);

    long countAllByStartDateBetween(LocalDate start, LocalDate end); //nove prijata prace

    long countAllByEndDateBetween(LocalDate start, LocalDate end); //absolventi

    long countByStartDateBetweenAndThesisType(LocalDate start, LocalDate end, ThesisType type);

    long countByEndDateBetweenAndThesisType(LocalDate start, LocalDate end, ThesisType type);

    @Query("SELECT DISTINCT YEAR(t.endDate) y FROM ThesisEntity t WHERE t.endDate IS NOT NULL UNION SELECT DISTINCT YEAR(t.startDate) y FROM ThesisEntity t WHERE t.startDate IS NOT NULL ORDER BY y")
    List<Integer> findYearsInDatabase();


}

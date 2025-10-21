package cz.newtworks.FGUApplication.specification;

import cz.newtworks.FGUApplication.dto.filter.ThesisFilterDTO;
import cz.newtworks.FGUApplication.entity.CouncilEntity;
import cz.newtworks.FGUApplication.entity.FacultyEntity;
import cz.newtworks.FGUApplication.entity.PersonEntity;
import cz.newtworks.FGUApplication.entity.ThesisEntity;
import jakarta.persistence.criteria.Join;
import jakarta.persistence.criteria.JoinType;
import jakarta.persistence.criteria.Predicate;
import org.springframework.data.jpa.domain.Specification;

import java.util.ArrayList;
import java.util.List;

public class ThesisSpecification {
    public static Specification<ThesisEntity> buildSpecification(ThesisFilterDTO thesisFilterDTO) {
        return (root, query, criteriaBuilder) -> {
            List<Predicate> predicates = new ArrayList<>();

            if (thesisFilterDTO.getNameCzFilter() != null && !thesisFilterDTO.getNameCzFilter().isEmpty()) {
                predicates.add(criteriaBuilder.like(
                        criteriaBuilder.lower(root.get("nameCz")),
                        "%" + thesisFilterDTO.getNameCzFilter().toLowerCase() + "%"
                ));
            }

            if (thesisFilterDTO.getNameEnFilter() != null && !thesisFilterDTO.getNameEnFilter().isEmpty()) {
                predicates.add(criteriaBuilder.like(
                        criteriaBuilder.lower(root.get("nameEn")),
                        "%" + thesisFilterDTO.getNameEnFilter().toLowerCase() + "%"
                ));
            }

            if (thesisFilterDTO.getThesisTypeFilter() != null) {
                predicates.add(criteriaBuilder.equal(
                        root.get("thesisType"),
                        thesisFilterDTO.getThesisTypeFilter()
                ));
            }

            if (thesisFilterDTO.getThesisStatusFilter() != null) {
                predicates.add(criteriaBuilder.equal(
                        root.get("thesisStatus"),
                        thesisFilterDTO.getThesisStatusFilter()
                ));
            }


            if (thesisFilterDTO.getEndDateFilterFrom() != null) {
                predicates.add(criteriaBuilder.greaterThanOrEqualTo(
                        root.get("endDate"),
                        thesisFilterDTO.getEndDateFilterFrom()
                ));
            }

            if (thesisFilterDTO.getEndDateFilterTo() != null) {
                predicates.add(criteriaBuilder.lessThanOrEqualTo(
                        root.get("endDate"),
                        thesisFilterDTO.getEndDateFilterTo()
                ));

            }

            if (thesisFilterDTO.getStartDateFilterFrom() != null) {
                predicates.add(criteriaBuilder.greaterThanOrEqualTo(
                        root.get("startDate"),
                        thesisFilterDTO.getStartDateFilterFrom()
                ));
            }

            if (thesisFilterDTO.getStartDateFilterTo() != null) {
                predicates.add(criteriaBuilder.lessThanOrEqualTo(
                        root.get("startDate"),
                        thesisFilterDTO.getStartDateFilterTo()
                ));

            }

            if (thesisFilterDTO.getStudentIdFilter() != 0) {
                Join<ThesisEntity, PersonEntity> personEntityJoin = root.join("student", JoinType.LEFT);

                predicates.add(criteriaBuilder.equal(
                        personEntityJoin.get("id"),
                        thesisFilterDTO.getStudentIdFilter()
                ));
            }

            if (thesisFilterDTO.getTrainerIdFilter() != 0) {
                Join<ThesisEntity, PersonEntity> personEntityJoin = root.join("trainer", JoinType.LEFT);

                predicates.add(criteriaBuilder.equal(
                        personEntityJoin.get("id"),
                        thesisFilterDTO.getTrainerIdFilter()
                ));
            }

            if (thesisFilterDTO.getConsultantIdFilter() != 0) {
                Join<ThesisEntity, PersonEntity> personEntityJoin = root.join("consultant", JoinType.LEFT);

                predicates.add(criteriaBuilder.equal(
                        personEntityJoin.get("id"),
                        thesisFilterDTO.getConsultantIdFilter()
                ));
            }

            if (thesisFilterDTO.getFacultyIdFilter() != 0) {
                Join<ThesisEntity, FacultyEntity> facultyEntityJoin = root.join("faculty", JoinType.LEFT);

                predicates.add(criteriaBuilder.equal(
                        facultyEntityJoin.get("id"),
                        thesisFilterDTO.getFacultyIdFilter()
                ));
            }

            if (thesisFilterDTO.getCouncilIdFilter() != 0) {
                Join<ThesisEntity, CouncilEntity> councilEntityJoin = root.join("council", JoinType.LEFT);

                predicates.add(criteriaBuilder.equal(
                        councilEntityJoin.get("id"),
                        thesisFilterDTO.getCouncilIdFilter()
                ));
            }


            return criteriaBuilder.and(predicates.toArray(predicates.toArray(new Predicate[0])));
        };

    }
}

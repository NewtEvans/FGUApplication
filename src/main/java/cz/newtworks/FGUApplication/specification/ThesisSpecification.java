package cz.newtworks.FGUApplication.specification;

import cz.newtworks.FGUApplication.dto.filter.ThesisFilterDTO;
import cz.newtworks.FGUApplication.entity.ThesisEntity;
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
            return criteriaBuilder.and(predicates.toArray(predicates.toArray(new Predicate[0])));
        };

    }
}

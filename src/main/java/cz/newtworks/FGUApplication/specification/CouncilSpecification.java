package cz.newtworks.FGUApplication.specification;

import cz.newtworks.FGUApplication.dto.filter.CouncilFilterDTO;
import cz.newtworks.FGUApplication.entity.CouncilEntity;
import jakarta.persistence.criteria.Predicate;
import org.springframework.data.jpa.domain.Specification;

import java.util.ArrayList;
import java.util.List;

public class CouncilSpecification {
    public static Specification<CouncilEntity> buildSpecification(CouncilFilterDTO councilFilterDTO) {
        return (root, query, criteriaBuilder) -> {
            List<Predicate> predicates = new ArrayList<>();

            if (councilFilterDTO.getCouncilNameFilter() != null && !councilFilterDTO.getCouncilNameFilter().isEmpty()) {
                predicates.add(criteriaBuilder.like(
                        criteriaBuilder.lower(root.get("councilName")),
                        "%" + councilFilterDTO.getCouncilNameFilter().toLowerCase() + "%"
                ));
            }

            if (councilFilterDTO.getCouncilAbbreviationFilter() != null && !councilFilterDTO.getCouncilAbbreviationFilter().isEmpty()) {
                predicates.add(criteriaBuilder.like(
                        criteriaBuilder.lower(root.get("councilAbbreviation")),
                        "%" + councilFilterDTO.getCouncilAbbreviationFilter().toLowerCase() + "%"
                ));
            }

            if (councilFilterDTO.getCouncilNumberFilter() != null && !councilFilterDTO.getCouncilNumberFilter().isEmpty()) {
                predicates.add(criteriaBuilder.like(
                        criteriaBuilder.lower(root.get("councilNumber")),
                        "%" + councilFilterDTO.getCouncilNumberFilter().toLowerCase() + "%"
                ));
            }

            return criteriaBuilder.and(predicates.toArray(predicates.toArray(new Predicate[0])));
        };


    }
}

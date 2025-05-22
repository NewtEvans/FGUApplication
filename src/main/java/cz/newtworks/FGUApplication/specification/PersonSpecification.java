package cz.newtworks.FGUApplication.specification;

import cz.newtworks.FGUApplication.dto.filter.PersonFilterDTO;
import cz.newtworks.FGUApplication.entity.PersonEntity;
import jakarta.persistence.criteria.Predicate;
import org.springframework.data.jpa.domain.Specification;

import java.util.ArrayList;
import java.util.List;

public class PersonSpecification {
    public static Specification<PersonEntity> buildSpecification(PersonFilterDTO personFilterDTO) {
        return (root, query, criteriaBuilder) -> {
            List<Predicate> predicates = new ArrayList<>();

            if (personFilterDTO.getNameFilter() != null && !personFilterDTO.getNameFilter().isEmpty()) {
                predicates.add(criteriaBuilder.like(
                        criteriaBuilder.lower(root.get("name")),
                        "%" + personFilterDTO.getNameFilter().toLowerCase() + "%"
                ));
            }

            if (personFilterDTO.getSurnameFilter() != null && !personFilterDTO.getSurnameFilter().isEmpty()) {
                predicates.add(criteriaBuilder.like(
                        criteriaBuilder.lower(root.get("surname")),
                        "%" + personFilterDTO.getSurnameFilter().toLowerCase() + "%"
                ));
            }
            return criteriaBuilder.and(predicates.toArray(predicates.toArray(new Predicate[0])));
        };
    }
}

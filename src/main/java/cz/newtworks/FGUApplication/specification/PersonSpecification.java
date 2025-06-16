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

            if (personFilterDTO.getFirstNameFilter() != null && !personFilterDTO.getFirstNameFilter().isEmpty()) {
                predicates.add(criteriaBuilder.like(
                        criteriaBuilder.lower(root.get("firstName")),
                        "%" + personFilterDTO.getFirstNameFilter().toLowerCase() + "%"
                ));
            }

            if (personFilterDTO.getSurnameFilter() != null && !personFilterDTO.getSurnameFilter().isEmpty()) {
                predicates.add(criteriaBuilder.like(
                        criteriaBuilder.lower(root.get("surname")),
                        "%" + personFilterDTO.getSurnameFilter().toLowerCase() + "%"
                ));
            }

            if (personFilterDTO.getIsArchivedFilter() != null) {
                predicates.add(criteriaBuilder.equal(
                        root.get("isArchived"),
                        personFilterDTO.getIsArchivedFilter()
                ));
            }

            return criteriaBuilder.and(predicates.toArray(predicates.toArray(new Predicate[0])));
        };
    }
}

package cz.newtworks.FGUApplication.specification;

import cz.newtworks.FGUApplication.dto.filter.FacultyFilterDTO;
import cz.newtworks.FGUApplication.entity.FacultyEntity;
import jakarta.persistence.criteria.Predicate;
import org.springframework.data.jpa.domain.Specification;

import java.util.ArrayList;
import java.util.List;

public class FacultySpecification {
    public static Specification<FacultyEntity> buildSpecification(FacultyFilterDTO facultyFilterDTO) {
        return (root, query, criteriaBuilder) -> {
            List<Predicate> predicates = new ArrayList<>();

            if (facultyFilterDTO.getFacultyNameFilter() != null && !facultyFilterDTO.getFacultyNameFilter().isEmpty()) {
                predicates.add(criteriaBuilder.like(
                        criteriaBuilder.lower(root.get("facultyName")),
                        "%" + facultyFilterDTO.getFacultyNameFilter().toLowerCase() + "%"
                ));
            }

            if (facultyFilterDTO.getSchoolFilter() != null && !facultyFilterDTO.getSchoolFilter().isEmpty()) {
                predicates.add(criteriaBuilder.like(
                        criteriaBuilder.lower(root.get("school")),
                        "%" + facultyFilterDTO.getSchoolFilter().toLowerCase() + "%"
                ));
            }

            if (facultyFilterDTO.getFacultyAbbreviationFilter() != null && !facultyFilterDTO.getFacultyAbbreviationFilter().isEmpty()) {
                predicates.add(criteriaBuilder.like(
                        criteriaBuilder.lower(root.get("facultyAbbreviation")),
                        "%" + facultyFilterDTO.getFacultyAbbreviationFilter().toLowerCase() + "%"
                ));
            }
            
            return criteriaBuilder.and(predicates.toArray(predicates.toArray(new Predicate[0])));
        };

    }
}





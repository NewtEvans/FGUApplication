package cz.newtworks.FGUApplication.specification;

import cz.newtworks.FGUApplication.dto.filter.DepartmentFilterDTO;
import cz.newtworks.FGUApplication.entity.DepartmentEntity;
import jakarta.persistence.criteria.Predicate;
import org.springframework.data.jpa.domain.Specification;

import java.util.ArrayList;
import java.util.List;

public class DepartmentSpecification {
    public static Specification<DepartmentEntity> buildSpecification(DepartmentFilterDTO departmentFilterDTO) {
        return (root, query, criteriaBuilder) -> {
            List<Predicate> predicates = new ArrayList<>();

            if (departmentFilterDTO.getDepartmentNameFilter() != null && !departmentFilterDTO.getDepartmentNameFilter().isEmpty()) {
                predicates.add(criteriaBuilder.like(
                        criteriaBuilder.lower(root.get("departmentName")),
                        "%" + departmentFilterDTO.getDepartmentNameFilter().toLowerCase() + "%"
                ));
            }

            if (departmentFilterDTO.getDepartmentNumberFilter() != null && !departmentFilterDTO.getDepartmentNumberFilter().isEmpty()) {
                predicates.add(criteriaBuilder.like(
                        criteriaBuilder.lower(root.get("departmentNumber")),
                        "%" + departmentFilterDTO.getDepartmentNumberFilter().toLowerCase() + "%"
                ));
            }
            return criteriaBuilder.and(predicates.toArray(predicates.toArray(new Predicate[0])));
        };
    }
}

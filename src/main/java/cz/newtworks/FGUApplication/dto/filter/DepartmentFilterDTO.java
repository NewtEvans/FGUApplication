package cz.newtworks.FGUApplication.dto.filter;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class DepartmentFilterDTO {

    private String departmentNumberFilter;

    private String departmentNameFilter;
}

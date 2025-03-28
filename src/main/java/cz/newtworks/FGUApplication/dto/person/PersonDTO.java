package cz.newtworks.FGUApplication.dto.person;

import cz.newtworks.FGUApplication.dto.department.DepartmentDTO;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Set;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PersonDTO {
    private Long id;
    private String titleBeforeName;
    private String name;
    private String surname;
    private String titleAfterName;
    private Set<DepartmentDTO> departments;
}

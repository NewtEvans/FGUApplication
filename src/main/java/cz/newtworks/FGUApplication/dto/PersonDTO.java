package cz.newtworks.FGUApplication.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import cz.newtworks.FGUApplication.constant.Role;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PersonDTO {
    private Long id;
    private String titleBeforeName;
    private String name;
    private String surname;
    private String titleAfterName;
    private Role role;
    private List<DepartmentDTO> departments;
}

package cz.newtworks.FGUApplication.dto;

import cz.newtworks.FGUApplication.constant.Role;
import cz.newtworks.FGUApplication.entity.DepartmentEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PersonDTO {
    private Long personId;
    private String titleBeforeName;


    private String name;
    private String surname;
    private String titleAfterName;
    private Role student;
    private List<DepartmentEntity> departments;
}

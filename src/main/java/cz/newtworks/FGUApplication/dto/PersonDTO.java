package cz.newtworks.FGUApplication.dto;

import cz.newtworks.FGUApplication.constant.Department;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PersonDTO {

    private Long id;
    private String titleBeforeName;
    private String name;
    private String surname;
    private String titleAfterName;
    private boolean student;
    private Department department;
}

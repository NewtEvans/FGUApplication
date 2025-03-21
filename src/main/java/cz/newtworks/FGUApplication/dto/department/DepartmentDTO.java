package cz.newtworks.FGUApplication.dto.department;

import com.fasterxml.jackson.annotation.JsonIgnore;
import cz.newtworks.FGUApplication.dto.person.PersonDTO;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class DepartmentDTO {
    private long id;
    private byte departmentNumber;
    private String departmentName;
    private List<PersonDTO> people;
}

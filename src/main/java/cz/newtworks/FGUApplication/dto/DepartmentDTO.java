package cz.newtworks.FGUApplication.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
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
    @JsonIgnore
    private List<PersonDTO> people;
}

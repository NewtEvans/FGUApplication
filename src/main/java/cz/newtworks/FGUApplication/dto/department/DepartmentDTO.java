package cz.newtworks.FGUApplication.dto.department;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class DepartmentDTO {
    private long id;
    private String departmentNumber;
    private String departmentName;
}

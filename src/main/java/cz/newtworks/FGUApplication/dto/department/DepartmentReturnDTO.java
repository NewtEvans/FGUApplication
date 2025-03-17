package cz.newtworks.FGUApplication.dto.department;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class DepartmentReturnDTO {
    private long id;
    private byte departmentNumber;
    private String departmentName;
}

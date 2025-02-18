package cz.newtworks.FGUApplication.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class DepartmentDTO {
    private long id;
    private byte departmentNumber;
    private String departmentName;
}

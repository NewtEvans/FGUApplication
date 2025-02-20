package cz.newtworks.FGUApplication.dto;

import cz.newtworks.FGUApplication.entity.PersonEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class DepartmentDTO {
    private long departmentId;
    private byte departmentNumber;
    private String departmentName;
}

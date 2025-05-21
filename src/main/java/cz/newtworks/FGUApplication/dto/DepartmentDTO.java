package cz.newtworks.FGUApplication.dto;


import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class DepartmentDTO {

    private long id;

    @NotBlank(message = "Department number is required.")
    private String departmentNumber;

    @NotBlank(message = "Department name is required.")
    private String departmentName;
}

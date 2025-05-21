package cz.newtworks.FGUApplication.dto;

import cz.newtworks.FGUApplication.constant.Employee;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Set;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class PersonDTO {

    private Long id;

    private String titleBeforeName;

    @NotBlank(message = "Person name is required.")
    private String name;

    @NotBlank(message = "Person surname is required.")
    private String surname;

    private String titleAfterName;

    private Employee isEmployee;

    //vazba mezi tabulkami
    private Set<DepartmentDTO> departments;
}

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
public class FacultyDTO {

    private Long id;

    @NotBlank(message = "Faculty name is required.")
    private String facultyName;

    private String facultyAbbreviation;

    @NotBlank(message = "School is required.")
    private String school;
}

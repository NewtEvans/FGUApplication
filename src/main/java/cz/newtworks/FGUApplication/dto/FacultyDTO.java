package cz.newtworks.FGUApplication.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class FacultyDTO {
    private long id;
    private String facultyName;
    private String facultyAbbreviation;
    private String school;
}

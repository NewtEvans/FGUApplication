package cz.newtworks.FGUApplication.dto;


import cz.newtworks.FGUApplication.entity.ThesisEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Set;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class FacultyDTO {
    private long id;
    private String facultyName;
    private String facultyAbbreviation;
    private Set<ThesisDTO> theses;
}

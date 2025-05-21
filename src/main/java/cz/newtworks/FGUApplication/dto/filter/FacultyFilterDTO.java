package cz.newtworks.FGUApplication.dto.filter;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class FacultyFilterDTO {

    private String facultyNameFilter;

    private String facultyAbbreviationFilter;

    private String schoolFilter;
}

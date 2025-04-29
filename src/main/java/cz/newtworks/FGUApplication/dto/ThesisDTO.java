package cz.newtworks.FGUApplication.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import cz.newtworks.FGUApplication.constant.ThesisType;
import cz.newtworks.FGUApplication.dto.person.PersonDTO;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ThesisDTO {

    private Long id;
    private ThesisType thesisType;
    private LocalDate startDate;
    private String nameCz;
    private String nameEn;
    private PersonDTO student;
    private PersonDTO trainer;
    private PersonDTO consultant;
    private FacultyDTO faculty;
    private CouncilDTO council;
    private int endDate;
    private String note;
}

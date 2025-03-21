package cz.newtworks.FGUApplication.dto;

import cz.newtworks.FGUApplication.entity.CouncilEntity;
import cz.newtworks.FGUApplication.entity.FacultyEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ThesisDTO {

    private long id;
    //private ThesisType thesisType;
    private LocalDate startDate;
    private String nameCz;
    private String nameEn;
//    private PersonDTO trainer;
//    private PersonDTO consultant;
    private FacultyDTO faculty;
    private CouncilDTO council;
    private LocalDate endDate;
    private String note;
}

package cz.newtworks.FGUApplication.dto;

import cz.newtworks.FGUApplication.constant.ThesisType;
import jakarta.validation.constraints.NotBlank;
import lombok.*;

import java.time.LocalDate;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ThesisDTO {

    private Long id;

    private ThesisType thesisType;

    private LocalDate startDate;

    @NotBlank(message = "Czech name is required.")
    private String nameCz;

    @NotBlank(message = "English name is required.")
    private String nameEn;

    private PersonDTO student;

    private PersonDTO trainer;

    private PersonDTO consultant;

    private FacultyDTO faculty;

    private CouncilDTO council;

    private LocalDate endDate;

    private String note;
}

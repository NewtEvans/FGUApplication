package cz.newtworks.FGUApplication.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import cz.newtworks.FGUApplication.constant.ThesisStatus;
import cz.newtworks.FGUApplication.constant.ThesisType;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ThesisDTO {

    private Long id;

    @NotBlank(message = "Thesis type is required.")
    private ThesisType thesisType;

    @JsonFormat(pattern = "yyyy-MM-dd")
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

    @JsonFormat(pattern = "yyyy-MM-dd")
    private LocalDate endDate;

    private String note;

    @NotBlank(message = "Thesis status is required.")
    private ThesisStatus thesisStatus;
}

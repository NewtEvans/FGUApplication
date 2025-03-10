package cz.newtworks.FGUApplication.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;


@Entity(name = "theses")
@Getter
@Setter
public class ThesisEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    //private ThesisType thesisType;

    private LocalDate startDate;

    private String nameCz;

    private String nameEn;

//    private PersonEntity trainer;

//    private PersonEntity consultant;

    @ManyToOne(fetch = FetchType.LAZY)
    private FacultyEntity faculty;

    @ManyToOne(fetch = FetchType.LAZY)
    private CouncilEntity council;

    private LocalDate endDate;

    private String note;

}

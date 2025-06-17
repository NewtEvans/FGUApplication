package cz.newtworks.FGUApplication.entity;

import cz.newtworks.FGUApplication.constant.ThesisType;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;


@Entity
@Table(name = "theses")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ThesisEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Enumerated(EnumType.STRING)
    private ThesisType thesisType;

    @Column
    private LocalDate startDate;

    @Column(nullable = false)
    private String nameCz;

    @Column(nullable = false)
    private String nameEn;

    @ManyToOne(fetch = FetchType.LAZY)
    private PersonEntity student;

    @ManyToOne(fetch = FetchType.LAZY)
    private PersonEntity trainer;

    @ManyToOne(fetch = FetchType.LAZY)
    private PersonEntity consultant;

    @ManyToOne(fetch = FetchType.LAZY)
    private FacultyEntity faculty;

    @ManyToOne(fetch = FetchType.LAZY)
    private CouncilEntity council;

    @Column
    private LocalDate endDate;

    @Column
    private String note;

}

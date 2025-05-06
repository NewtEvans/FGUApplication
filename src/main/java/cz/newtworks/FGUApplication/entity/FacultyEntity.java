package cz.newtworks.FGUApplication.entity;

import jakarta.persistence.*;
import lombok.*;


import java.util.Set;

@Entity
@Table(name = "faculties")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class FacultyEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(nullable = false)
    private String facultyName;

    @Column
    private String facultyAbbreviation;

    @Column(nullable = false)
    private String school;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "faculty")
    private Set<ThesisEntity> theses;
}

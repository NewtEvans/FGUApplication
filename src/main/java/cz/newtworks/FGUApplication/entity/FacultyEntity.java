package cz.newtworks.FGUApplication.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Set;

@Entity
@Table(name = "faculties")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
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

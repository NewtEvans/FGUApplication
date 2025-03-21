package cz.newtworks.FGUApplication.entity;

import jakarta.annotation.Nullable;
import jakarta.persistence.*;
import lombok.Data;


import java.util.Set;

@Entity(name = "faculties")
@Data
public class FacultyEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(nullable = false)
    private String facultyName;

    @Column
    private String facultyAbbreviation;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "faculty")
    private Set<ThesisEntity> theses;
}

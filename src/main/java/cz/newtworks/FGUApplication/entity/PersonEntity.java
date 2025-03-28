package cz.newtworks.FGUApplication.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;


@Entity
@Table(name = "people")
@Getter
@Setter
public class PersonEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String titleBeforeName;

//    @Column(nullable = false)
    private String name;

//    @Column(nullable = false)
    private String surname;

    private String titleAfterName;

    //vazba mezi tabulkami - department
    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(
            name = "person_department",
            joinColumns = @JoinColumn(name = "person_id"),
            inverseJoinColumns = @JoinColumn(name = "department_id")
    )
    List<DepartmentEntity> departments;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "student")
    private List<ThesisEntity> studied;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "trainer")
    private List<ThesisEntity> trained;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "consultant")
    private List<ThesisEntity> consulted;
}

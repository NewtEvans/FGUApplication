package cz.newtworks.FGUApplication.entity;

import cz.newtworks.FGUApplication.constant.Employee;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;
import java.util.Set;


@Entity
@Table(name = "people")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class PersonEntity {

    //vazba mezi tabulkami
    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(
            name = "person_department",
            joinColumns = @JoinColumn(name = "person_id"),
            inverseJoinColumns = @JoinColumn(name = "department_id")
    )
    Set<DepartmentEntity> departments;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String titleBeforeName;

    @Column(nullable = false)
    private String firstName;

    @Column(nullable = false)
    private String surname;

    private String titleAfterName;

    private boolean isArchived;

    @Enumerated(EnumType.STRING)
    private Employee isEmployee;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "student")
    private List<ThesisEntity> studied;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "trainer")
    private List<ThesisEntity> trained;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "consultant")
    private List<ThesisEntity> consulted;
}

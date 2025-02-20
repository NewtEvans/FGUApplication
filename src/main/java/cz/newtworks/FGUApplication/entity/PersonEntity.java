package cz.newtworks.FGUApplication.entity;

import cz.newtworks.FGUApplication.constant.Role;
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
    private long personId;

    private String titleBeforeName;

    @Column
    private String name;

//    @Column(nullable = false)
    private String surname;

    private String titleAfterName;

//  @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private Role student;

    //vazba mezi tabulkami - department
    @ManyToMany
    @JoinTable(
            name = "people_departments",
            joinColumns = @JoinColumn(name = "personId"),
            inverseJoinColumns = @JoinColumn(name = "departmentId")
    )
    private List<DepartmentEntity> departments;
}

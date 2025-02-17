package cz.newtworks.FGUApplication.entity;

import cz.newtworks.FGUApplication.constant.Department;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;


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

    private boolean student;

    //@Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private Department department;
}

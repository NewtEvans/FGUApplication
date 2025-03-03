package cz.newtworks.FGUApplication.entity;

import cz.newtworks.FGUApplication.constant.Role;
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

//  @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private Role role;

    //vazba mezi tabulkami - department
}

package cz.newtworks.FGUApplication.entity;


import jakarta.persistence.Entity;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Table(name = "department")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class DepartmentEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(nullable = false)
    private String departmentNumber;

    @Column(nullable = false)
    private String departmentName;

    @ManyToMany(mappedBy = "departments", fetch = FetchType.EAGER)
    List<PersonEntity> people;
}

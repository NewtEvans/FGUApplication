package cz.newtworks.FGUApplication.entity;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Entity
@Table(name = "department")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class DepartmentEntity {

    @ManyToMany(mappedBy = "departments", fetch = FetchType.EAGER)
    List<PersonEntity> people;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column(nullable = false)
    private String departmentNumber;
    @Column(nullable = false)
    private String departmentName;
}

package cz.newtworks.FGUApplication.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Entity(name = "department")
@Data
public class DepartmentEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column
    private byte departmentNumber;

    @Column
    private String departmentName;

    @ManyToMany(mappedBy = "departments")
    private List<PersonEntity> people;
}

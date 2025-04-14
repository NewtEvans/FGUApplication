package cz.newtworks.FGUApplication.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.Entity;
import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Entity(name = "department")
@Data
public class
DepartmentEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column
    private String departmentNumber;

    @Column
    private String departmentName;

    @ManyToMany(mappedBy = "departments", fetch = FetchType.EAGER)
    List<PersonEntity> people;
}

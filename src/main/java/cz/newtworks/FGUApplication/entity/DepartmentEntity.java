package cz.newtworks.FGUApplication.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.Entity;
import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Entity(name = "department")
@Data
public class DepartmentEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long departmentId;

    @Column
    private byte departmentNumber;

    @Column
    private String departmentName;

    @ManyToMany(mappedBy = "departments")
    @JsonIgnore
    private List<PersonEntity> people;
}

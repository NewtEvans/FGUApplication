package cz.newtworks.FGUApplication.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Set;

@Entity
@Table(name = "councils")
@Getter
@Setter

public class CouncilEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column
    private String councilName;

    @Column
    private String councilAbbreviation;

    @Column
    private String councilNumber;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "council")
    private Set<ThesisEntity> theses;
}

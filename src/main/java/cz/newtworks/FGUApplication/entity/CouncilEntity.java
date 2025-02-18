package cz.newtworks.FGUApplication.entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity(name = "council")
@Data
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
}

package cz.newtworks.FGUApplication.dto;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CouncilDTO {
    private long id;
    private String councilName;
    private String councilAbbreviation;
    private String councilNumber;
}

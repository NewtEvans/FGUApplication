package cz.newtworks.FGUApplication.dto;


import jakarta.validation.constraints.NotBlank;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CouncilDTO {

    private long id;

    @NotBlank(message = "Council name is required.")
    private String councilName;

    private String councilAbbreviation;

    private String councilNumber;
}

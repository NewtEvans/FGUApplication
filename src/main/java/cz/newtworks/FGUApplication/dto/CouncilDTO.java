package cz.newtworks.FGUApplication.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CouncilDTO {

    private Long id;

    @NotBlank(message = "Council name is required.")
    private String councilName;

    private String councilAbbreviation;

    private String councilNumber;
}

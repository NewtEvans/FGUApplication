package cz.newtworks.FGUApplication.dto.special;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CouncilNameOnlyDTO {
    private Long id;

    private String councilName;
}

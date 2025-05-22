package cz.newtworks.FGUApplication.dto.filter;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CouncilFilterDTO {

    private String councilNameFilter;

    private String councilAbbreviationFilter;

    private String councilNumberFilter;
}

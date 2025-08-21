package cz.newtworks.FGUApplication.dto.special;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class PersonNameSurnameDTO {

    private Long id;
    private String firstName;
    private String surname;
    
}

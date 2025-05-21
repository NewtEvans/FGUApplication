package cz.newtworks.FGUApplication.dto.filter;

import cz.newtworks.FGUApplication.constant.Employee;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class PersonFilterDTO {

    private Long id;

    private String titleBeforeName;

    private String name;

    private String surname;

    private String titleAfterName;

    private Employee isEmployee;

}

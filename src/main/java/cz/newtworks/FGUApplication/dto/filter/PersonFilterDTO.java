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

    private String titleBeforeNameFilter;

    private String nameFilter;

    private String surnameFilter;

    private String titleAfterNameFilter;

    private Employee isEmployeeFilter;

}

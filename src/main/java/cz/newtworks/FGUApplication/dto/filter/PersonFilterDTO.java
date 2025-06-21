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

    private String firstNameFilter;

    private String surnameFilter;

    private String titleAfterNameFilter;

    private Boolean isArchivedFilter = false;

    private Employee isEmployeeFilter;


}

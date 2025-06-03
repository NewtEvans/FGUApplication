package cz.newtworks.FGUApplication.dto.filter;

import com.fasterxml.jackson.annotation.JsonFormat;
import cz.newtworks.FGUApplication.constant.ThesisType;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ThesisFilterDTO {

    private Long id;

    private ThesisType thesisTypeFilter;

    @JsonFormat(pattern = "yyyy-MM-dd")
    private LocalDate startDateFilterFrom;

    @JsonFormat(pattern = "yyyy-MM-dd")
    private LocalDate startDateFilterTo;

    private String nameCzFilter;

    private String nameEnFilter;

    @JsonFormat(pattern = "yyyy-MM-dd")
    private LocalDate endDateFilterFrom;

    @JsonFormat(pattern = "yyyy-MM-dd")
    private LocalDate endDateFilterTo;

}

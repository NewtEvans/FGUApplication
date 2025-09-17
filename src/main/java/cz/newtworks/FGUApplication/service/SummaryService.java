package cz.newtworks.FGUApplication.service;

import cz.newtworks.FGUApplication.dto.SummaryDTO;

import java.time.LocalDate;

public interface SummaryService {

    /**
     *
     * @param date
     * @return
     */
    SummaryDTO getNumberOfAllFinishedTheses(LocalDate date);

    /**
     *
     * @param date
     * @return
     */
    SummaryDTO getNumberOfAllNewTheses(LocalDate date);

    /**
     *
     * @param date
     * @return
     */
    SummaryDTO getNumberOfOngoingTheses(LocalDate date);

    /**
     *
     * @param year
     * @return
     */
    SummaryDTO getCompleteSummary(int year);

}

package cz.newtworks.FGUApplication.service;

import cz.newtworks.FGUApplication.dto.SummaryDTO;

import java.time.LocalDate;

public interface SummaryService {
//TODO doplnit dokumentaci
    
    /**
     *
     *
     * @param date
     * @return
     */
    SummaryDTO getNumberOfAllFinishedTheses(LocalDate date);

    /**
     *
     *
     * @param date
     * @return
     */
    SummaryDTO getNumberOfAllNewTheses(LocalDate date);

    /**
     *
     *
     * @param date
     * @return
     */
    SummaryDTO getNumberOfOngoingTheses(LocalDate date);

    /**
     *
     *
     * @return
     */
    SummaryDTO getNumberOfAllPausedTheses();

    /**
     *
     *
     * @return
     */
    SummaryDTO getNumberOfAbandonedTheses();

    /**
     * Method returns DTO with complete summary from the database.
     *
     * @param year
     * @return DTO with complete summary
     */
    SummaryDTO getCompleteSummary(int year);

}

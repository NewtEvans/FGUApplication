package cz.newtworks.FGUApplication.service;

import cz.newtworks.FGUApplication.dto.SummaryDTO;

import java.time.LocalDate;

public interface SummaryService {

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

    //TODO doplnit dokumentaci
    SummaryDTO getNumberOfAllPausedTheses();

    //TODO doplnit dokumentaci
    SummaryDTO getNumberOfAbandonedTheses();

    /**
     * Method returns DTO with complete summary from the database.
     *
     * @param year
     * @return DTO with complete summary
     */
    SummaryDTO getCompleteSummary(int year);

}

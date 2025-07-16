package cz.newtworks.FGUApplication.service;

import cz.newtworks.FGUApplication.dto.SummaryDTO;

import java.time.LocalDate;

public interface SummaryService {

    SummaryDTO getNumberOfAllFinishedTheses(LocalDate date);

    SummaryDTO getNumberOfAllNewTheses(LocalDate date);

    SummaryDTO getNumberOfOngoingTheses(LocalDate date);

    SummaryDTO getCompleteSummary(int year);

}

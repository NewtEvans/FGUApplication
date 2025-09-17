package cz.newtworks.FGUApplication.service;

import cz.newtworks.FGUApplication.constant.ThesisType;
import cz.newtworks.FGUApplication.dto.SummaryDTO;
import cz.newtworks.FGUApplication.dto.mapper.ThesisMapper;
import cz.newtworks.FGUApplication.entity.repository.ThesisRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

@Service
public class SummaryServiceImpl implements SummaryService {

    @Autowired
    ThesisRepository thesisRepository;

    @Autowired
    ThesisMapper thesisMapper;

    @Override
    public SummaryDTO getNumberOfAllFinishedTheses(LocalDate date) {
        return null;
    }

    @Override
    public SummaryDTO getNumberOfAllNewTheses(LocalDate date) {
        return null;
    }

    @Override
    public SummaryDTO getNumberOfOngoingTheses(LocalDate date) {
        return null;
    }

    @Override
    public SummaryDTO getCompleteSummary(int year) {
        SummaryDTO summaryDTO = new SummaryDTO();

        summaryDTO.setNumberOfNewTheses(getNumberOfThesesByStartYear(year));
        summaryDTO.setNewBakalarska(getNumberOfThesesByStartYear(year, ThesisType.bakalarska));
        summaryDTO.setNewMagisterska(getNumberOfThesesByStartYear(year, ThesisType.magisterska));
        summaryDTO.setNewDoktorandska(getNumberOfThesesByStartYear(year, ThesisType.doktorandska));
        summaryDTO.setNewInzenyrska(getNumberOfThesesByStartYear(year, ThesisType.inzenyrska));

        summaryDTO.setNumberOfEndedTheses(getNumberOfThesesByEndYear(year));
        summaryDTO.setEndedBakalarska(getNumberOfThesesByEndYear(year, ThesisType.bakalarska));
        summaryDTO.setEndedMagisterska(getNumberOfThesesByEndYear(year, ThesisType.magisterska));
        summaryDTO.setEndedDoktorandska(getNumberOfThesesByEndYear(year, ThesisType.doktorandska));
        summaryDTO.setEndedInzenyrska(getNumberOfThesesByEndYear(year, ThesisType.inzenyrska));
        return summaryDTO;
    }

    //Private methods

    /**
     * Method that returns number
     *
     * @param year
     * @return
     */
    private int getNumberOfThesesByStartYear(int year) {
        LocalDate start = LocalDate.of(year, 1, 1);
        LocalDate end = LocalDate.of(year, 12, 31);
        return thesisRepository.countAllByStartDateBetween(start, end);
    }

    private int getNumberOfThesesByStartYear(int year, ThesisType thesisType) {
        LocalDate start = LocalDate.of(year, 1, 1);
        LocalDate end = LocalDate.of(year, 12, 31);
        return thesisRepository.findNewThesesByStartDateAndThesisType(start, end, thesisType);
    }

    private int getNumberOfThesesByEndYear(int year) {
        LocalDate start = LocalDate.of(year, 1, 1);
        LocalDate end = LocalDate.of(year, 12, 31);
        return thesisRepository.findAllByEndDateBetween(start, end);
    }

    private int getNumberOfThesesByEndYear(int year, ThesisType thesisType) {
        LocalDate start = LocalDate.of(year, 1, 1);
        LocalDate end = LocalDate.of(year, 12, 31);
        return thesisRepository.findEndedThesesByEndDateAndThesisType(start, end, thesisType);
    }


}

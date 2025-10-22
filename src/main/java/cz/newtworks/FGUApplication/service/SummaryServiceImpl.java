package cz.newtworks.FGUApplication.service;

import cz.newtworks.FGUApplication.constant.ThesisStatus;
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
    public SummaryDTO getNumberOfAllPausedTheses() {
        return null;
    }

    @Override
    public SummaryDTO getNumberOfAbandonedTheses() {
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

        summaryDTO.setNumberOfAbandonedTheses(getNumberOfThesesByEndYear(year, ThesisStatus.PREDCASNE_UKONCENA));
        summaryDTO.setAbandonedBakalarska(getNumberOfThesesByEndYear(year, ThesisType.bakalarska, ThesisStatus.PREDCASNE_UKONCENA));
        summaryDTO.setAbandonedMagisterska(getNumberOfThesesByEndYear(year, ThesisType.magisterska, ThesisStatus.PREDCASNE_UKONCENA));
        summaryDTO.setAbandonedDoktorandska(getNumberOfThesesByEndYear(year, ThesisType.doktorandska, ThesisStatus.PREDCASNE_UKONCENA));
        summaryDTO.setAbandonedInzenyrska(getNumberOfThesesByEndYear(year, ThesisType.inzenyrska, ThesisStatus.PREDCASNE_UKONCENA));

        summaryDTO.setNumberOfPausedTheses(getNumberOfThesesByEndYear(year, ThesisStatus.PRERUSENA));
        summaryDTO.setPausedBakalarska(getNumberOfThesesByEndYear(year, ThesisType.bakalarska, ThesisStatus.PRERUSENA));
        summaryDTO.setPausedMagisterska(getNumberOfThesesByEndYear(year, ThesisType.magisterska, ThesisStatus.PRERUSENA));
        summaryDTO.setPausedDoktorandska(getNumberOfThesesByEndYear(year, ThesisType.doktorandska, ThesisStatus.PRERUSENA));
        summaryDTO.setPausedInzenyrska(getNumberOfThesesByEndYear(year, ThesisType.inzenyrska, ThesisStatus.PRERUSENA));
        
        return summaryDTO;
    }

    //Private methods

    /**
     * Method that returns number
     *
     * @param year
     * @return
     */
    private long getNumberOfThesesByStartYear(int year) {
        LocalDate start = LocalDate.of(year, 1, 1);
        LocalDate end = LocalDate.of(year, 12, 31);
        return thesisRepository.countAllByStartDateBetween(start, end);
    }

    private long getNumberOfThesesByStartYear(int year, ThesisType thesisType) {
        LocalDate start = LocalDate.of(year, 1, 1);
        LocalDate end = LocalDate.of(year, 12, 31);
        return thesisRepository.countByStartDateBetweenAndThesisType(start, end, thesisType);
    }

    private long getNumberOfThesesByStartYear(int year, ThesisStatus thesisStatus) {
        LocalDate start = LocalDate.of(year, 1, 1);
        LocalDate end = LocalDate.of(year, 12, 31);
        return thesisRepository.countByStartDateBetweenAndThesisStatus(start, end, thesisStatus);
    }

    private long getNumberOfThesesByEndYear(int year) {
        LocalDate start = LocalDate.of(year, 1, 1);
        LocalDate end = LocalDate.of(year, 12, 31);
        return thesisRepository.countAllByEndDateBetween(start, end);
    }

    private long getNumberOfThesesByEndYear(int year, ThesisType thesisType) {
        LocalDate start = LocalDate.of(year, 1, 1);
        LocalDate end = LocalDate.of(year, 12, 31);
        return thesisRepository.countByEndDateBetweenAndThesisType(start, end, thesisType);
    }

    private long getNumberOfThesesByEndYear(int year, ThesisStatus thesisStatus) {
        LocalDate start = LocalDate.of(year, 1, 1);
        LocalDate end = LocalDate.of(year, 12, 31);
        return thesisRepository.countByEndDateBetweenAndThesisStatus(start, end, thesisStatus);
    }

    private long getNumberOfThesesByEndYear(int year, ThesisType thesisType, ThesisStatus thesisStatus) {
        LocalDate start = LocalDate.of(year, 1, 1);
        LocalDate end = LocalDate.of(year, 12, 31);
        return thesisRepository.countByEndDateBetweenAndThesisStatusAndThesisType(start, end, thesisStatus, thesisType);
    }


}

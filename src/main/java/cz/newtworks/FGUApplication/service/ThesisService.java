package cz.newtworks.FGUApplication.service;

import cz.newtworks.FGUApplication.dto.ThesisDTO;

import java.util.List;

public interface ThesisService {

    /**
     * Method creates a new thesis into the database.
     * @param thesisDTO
     * @return DTO with new theses from the database
     */
    ThesisDTO addThesis(ThesisDTO thesisDTO);

    /**
     * Method returns details of thesis with requested id.
     * @param thesisId Requested id
     * @return DTO with detail of thesis with requested id
     */
    ThesisDTO detailThesis(long thesisId);

    /**
     * Method returns all theses in the database.
     * @return List of all theses in the database
     */
    List<ThesisDTO> getAllThesis();


    /**
     * Method returns all thesis contains consultant with requested id.
     * @param consultantId
     * @return List of all theses with requested consultant id
     */
    List<ThesisDTO> getAllThesisWithConsultantId(long consultantId);

    /**
     * Method returns all thesis contains student with requested id.
     * @param studentId
     * @return List of all theses with requested student id
     */
    List<ThesisDTO> getAllThesisWithStudentId(long studentId);

    /**
     * Method returns all thesis contains trainer with requested id.
     * @param trainerId
     * @return List of all theses with requested trainer id
     */
    List<ThesisDTO> getAllThesisWithTrainerId(long trainerId);

    /**
     * Method edits already created thesis.
     * @param thesisId id of edited thesis
     * @param thesisDTO new thesis data
     * @return DTO with updated thesis
     */
    ThesisDTO editThesis(long thesisId, ThesisDTO thesisDTO);

    /**
     * Method deletes thesis.
     * @param thesisId is of deleted thesis
     */
    void deleteThesis(long thesisId);
}

package cz.newtworks.FGUApplication.service;

import cz.newtworks.FGUApplication.dto.ThesisDTO;

import java.util.List;

public interface ThesisService {

    /**
     * Method creates a new thesis into the database.
     * @param thesisDTO
     * @return DTO with new theses from the database.
     */
    ThesisDTO addThesis(ThesisDTO thesisDTO);

    ThesisDTO detailThesis(long thesisId);

    List<ThesisDTO> getAllThesis();
}

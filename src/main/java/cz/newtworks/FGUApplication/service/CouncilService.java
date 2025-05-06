package cz.newtworks.FGUApplication.service;

import cz.newtworks.FGUApplication.dto.CouncilDTO;
import cz.newtworks.FGUApplication.exception.ResourceNotFoundException;

import java.util.List;

public interface CouncilService {

    /**
     * Method creates a new council into the database.
     * @param councilDTO
     * @return DTO with freshly created council
     */
    CouncilDTO addCouncil(CouncilDTO councilDTO);

    /**
     * Method returns list with all councils in the database.
     * @return List of all councils in the database
     */
    List<CouncilDTO> getAllCouncils();

    /**
     * Method returns details of council with requested id.
     * @param councilId
     * @return DTO with detail of council with requested id
     */
    CouncilDTO getCouncilById(long councilId) throws ResourceNotFoundException;

    /**
     * Method edits already created council.
     * @param councilId id of edited council
     * @param councilDTO new council data
     * @return DTO with updated council
     */
    CouncilDTO editCouncil(long councilId, CouncilDTO councilDTO);

    /**
     * Method deletes council with requested id.
     * @param councilId id of council to delete
     */
    void deleteCouncil(long councilId);
}

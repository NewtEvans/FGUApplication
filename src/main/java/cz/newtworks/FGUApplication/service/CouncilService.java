package cz.newtworks.FGUApplication.service;

import cz.newtworks.FGUApplication.dto.CouncilDTO;
import cz.newtworks.FGUApplication.dto.filter.CouncilFilterDTO;
import cz.newtworks.FGUApplication.exception.ResourceNotFoundException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;


public interface CouncilService {

    /**
     * Method creates a new council into the database.
     *
     * @param councilDTO
     * @return DTO with freshly created council
     */
    CouncilDTO addCouncil(CouncilDTO councilDTO);

    /**
     * Method returns all councils in the database.
     * Contains pagination and specification component.
     *
     * @return Page with all councils in the database
     */
    Page<CouncilDTO> getAllCouncils(Pageable pageable, CouncilFilterDTO councilFilterDTO);

    /**
     * Method returns details of council with requested id.
     *
     * @param councilId
     * @return DTO with detail of council with requested id
     * @throws ResourceNotFoundException if council with requested id doesn't exist
     */
    CouncilDTO getCouncilById(long councilId) throws ResourceNotFoundException;

    /**
     * Method edits already created council.
     *
     * @param councilId  id of edited council
     * @param councilDTO new council data
     * @return DTO with updated council
     */
    CouncilDTO editCouncil(long councilId, CouncilDTO councilDTO);

    /**
     * Method deletes council with requested id.
     *
     * @param councilId id of council to delete
     */
    void deleteCouncil(long councilId);
}

package cz.newtworks.FGUApplication.service;

import cz.newtworks.FGUApplication.dto.CouncilDTO;
import cz.newtworks.FGUApplication.dto.mapper.CouncilMapper;
import cz.newtworks.FGUApplication.entity.CouncilEntity;
import cz.newtworks.FGUApplication.entity.repository.CouncilRepository;
import cz.newtworks.FGUApplication.exception.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CouncilServiceImpl implements CouncilService{

    @Autowired
    private CouncilRepository councilRepository;

    @Autowired
    private CouncilMapper councilMapper;

    @Override
    public CouncilDTO addCouncil(CouncilDTO councilDTO) {
        CouncilEntity council = councilMapper.toEntity(councilDTO);
        councilRepository.save(council);

        return councilMapper.toDTO(council);
    }

    @Override
    public Page<CouncilDTO> getAllCouncils(Pageable pageable) {
        return councilRepository.findAll(pageable)
                .map(councilMapper::toDTO);
    }

    @Override
    public CouncilDTO getCouncilById(long councilId) {
        return councilMapper.toDTO(fetchCouncilById(councilId));
    }

    @Override
    public CouncilDTO editCouncil(long councilId, CouncilDTO councilDTO) {
        CouncilEntity council = councilMapper.toEntity(councilDTO);
        council.setId(councilId);
        councilRepository.save(council);

        return councilMapper.toDTO(fetchCouncilById(councilId));
    }

    @Override
    public void deleteCouncil(long councilId) {
        councilRepository.delete(fetchCouncilById(councilId));
    }

    //Private methods

    /**
     * Returns a council entity by ID
     * @param councilId councilId the ID of the council
     * @return the found CouncilEntity
     * @throws ResourceNotFoundException if no council with the given ID is found
     */
    private CouncilEntity fetchCouncilById(long councilId){
       return councilRepository.findById(councilId)
                .orElseThrow(() -> new ResourceNotFoundException("Council with ID " + councilId + " was not found in the database."));
    }
}

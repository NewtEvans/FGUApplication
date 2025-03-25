package cz.newtworks.FGUApplication.service;

import cz.newtworks.FGUApplication.dto.CouncilDTO;
import cz.newtworks.FGUApplication.dto.mapper.CouncilMapper;
import cz.newtworks.FGUApplication.entity.CouncilEntity;
import cz.newtworks.FGUApplication.entity.repository.CouncilRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
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
    public List<CouncilDTO> getAllCouncils() {
        return councilRepository.findAll()
                .stream()
                .map(councilEntity -> councilMapper.toDTO(councilEntity))
                .collect(Collectors.toList());
    }

    @Override
    public CouncilDTO councilDetail(long councilId) {
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
     * Private method that returns council entity with specific ID.
     * If asked ID doesn't exist method returns error exception.
     * @param councilId
     * @return Council entity with asked id
     */
    private CouncilEntity fetchCouncilById(long councilId){
       return councilRepository.findById(councilId)
                .orElseThrow(() -> new EntityNotFoundException("Council with id " + councilId + " wasn't found in the database."));
    }
}

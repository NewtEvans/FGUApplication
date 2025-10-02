package cz.newtworks.FGUApplication.service;

import cz.newtworks.FGUApplication.dto.CouncilDTO;
import cz.newtworks.FGUApplication.dto.filter.CouncilFilterDTO;
import cz.newtworks.FGUApplication.dto.mapper.CouncilMapper;
import cz.newtworks.FGUApplication.dto.special.CouncilNameOnlyDTO;
import cz.newtworks.FGUApplication.entity.CouncilEntity;
import cz.newtworks.FGUApplication.entity.repository.CouncilRepository;
import cz.newtworks.FGUApplication.exception.ResourceNotFoundException;
import cz.newtworks.FGUApplication.specification.CouncilSpecification;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CouncilServiceImpl implements CouncilService {

    @Autowired
    private CouncilRepository councilRepository;

    @Autowired
    private CouncilMapper councilMapper;

    @Override
    public CouncilDTO createCouncil(CouncilDTO councilDTO) {
        CouncilEntity council = councilMapper.toEntity(councilDTO);
        councilRepository.save(council);

        return councilMapper.toDTO(council);
    }

    @Override
    public void createMultipleCouncils(List<CouncilDTO> councilDTOs) {
        List<CouncilEntity> councilEntities = councilDTOs.stream()
                .map(councilDTO -> councilMapper.toEntity(councilDTO))
                .collect(Collectors.toList());

        councilRepository.saveAll(councilEntities);
    }

    @Override
    public Page<CouncilDTO> getAllCouncilsPageable(Pageable pageable, CouncilFilterDTO councilFilterDTO) {
        Specification<CouncilEntity> specification = CouncilSpecification.buildSpecification(councilFilterDTO);

        return councilRepository.findAll(specification, pageable)
                .map(councilMapper::toDTO);
    }

    @Override
    public List<CouncilNameOnlyDTO> getAllCouncils() {
        return councilRepository.findAll()
                .stream()
                .map(councilEntity -> councilMapper.toNameOnlyDTO(councilEntity))
                .collect(Collectors.toList());
    }

    @Override
    public int countCouncils() {
        return councilRepository.countAllCouncils();
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
     * Method that returns the council entity with a specific ID and returns exception if no council with the given ID is found.
     *
     * @param councilId councilId the ID of the council
     * @return the found CouncilEntity
     * @throws ResourceNotFoundException if no council with the given ID is found
     */
    private CouncilEntity fetchCouncilById(long councilId) {
        return councilRepository.findById(councilId)
                .orElseThrow(() -> new ResourceNotFoundException("Council with ID " + councilId + " was not found in the database."));
    }
}

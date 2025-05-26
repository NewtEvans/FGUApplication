package cz.newtworks.FGUApplication.service;

import cz.newtworks.FGUApplication.dto.ThesisDTO;
import cz.newtworks.FGUApplication.dto.filter.ThesisFilterDTO;
import cz.newtworks.FGUApplication.dto.mapper.PersonMapper;
import cz.newtworks.FGUApplication.dto.mapper.ThesisMapper;
import cz.newtworks.FGUApplication.entity.ThesisEntity;
import cz.newtworks.FGUApplication.entity.repository.CouncilRepository;
import cz.newtworks.FGUApplication.entity.repository.FacultyRepository;
import cz.newtworks.FGUApplication.entity.repository.PersonRepository;
import cz.newtworks.FGUApplication.entity.repository.ThesisRepository;
import cz.newtworks.FGUApplication.exception.ResourceNotFoundException;
import cz.newtworks.FGUApplication.specification.ThesisSpecification;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ThesisServiceImpl implements ThesisService {

    @Autowired
    private ThesisRepository thesisRepository;

    @Autowired
    private ThesisMapper thesisMapper;

    @Autowired
    private PersonService personService;

    @Autowired
    private PersonMapper personMapper;

    @Autowired
    private PersonRepository personRepository;

    @Autowired
    private FacultyService facultyService;

    @Autowired
    private FacultyRepository facultyRepository;

    @Autowired
    private CouncilService councilService;

    @Autowired
    private CouncilRepository councilRepository;

    @Override
    public ThesisDTO addThesis(ThesisDTO thesisDTO) {
        ThesisEntity entity = thesisMapper.toEntity(thesisDTO);

        thesisRepository.save(entity);

        return fillThesisWithDTOs(thesisMapper.toDTO(entity), entity);
    }

    @Override
    public ThesisDTO getThesisById(long thesisId) {
        ThesisEntity thesis = fetchThesisById(thesisId);

        return thesisMapper.toDTO(thesis);
    }

    @Override
    public Page<ThesisDTO> getAllThesis(Pageable pageable, ThesisFilterDTO thesisFilterDTO) {
        Specification<ThesisEntity> specification = ThesisSpecification.buildSpecification(thesisFilterDTO);

        return thesisRepository.findAll(specification, pageable)
                .map(thesisMapper::toDTO);
    }

    @Override
    public List<ThesisDTO> getAllThesisWithConsultantId(long consultantId) {
        return thesisRepository.findAllThesisWithConsultantId(consultantId)
                .stream()
                .map(thesisEntity -> thesisMapper.toDTO(thesisEntity))
                .collect(Collectors.toList());
    }

    @Override
    public List<ThesisDTO> getAllThesisWithStudentId(long studentId) {
        return thesisRepository.findAllThesisWithStudentId(studentId)
                .stream()
                .map(thesisEntity -> thesisMapper.toDTO(thesisEntity))
                .collect(Collectors.toList());
    }

    @Override
    public List<ThesisDTO> getAllThesisWithTrainerId(long trainerId) {
        return thesisRepository.findAllThesisWithTrainerId(trainerId)
                .stream()
                .map(thesisEntity -> thesisMapper.toDTO(thesisEntity))
                .collect(Collectors.toList());
    }

    @Override
    public ThesisDTO editThesis(long thesisId, ThesisDTO thesisDTO) {
        ThesisEntity thesis = thesisMapper.toEntity(thesisDTO);
        thesis.setId(thesisId);
        thesisRepository.save(thesis);

        return thesisMapper.toDTO(fetchThesisById(thesisId));
    }

    @Override
    public void deleteThesis(long thesisId) {
        thesisRepository.delete(fetchThesisById(thesisId));
    }

    //Private methods

    /**
     * Private method that returns thesis entity with specific ID.
     * If asked ID doesn't exist method returns error exception.
     *
     * @param thesisId
     * @return Thesis entity with asked id
     * @throws ResourceNotFoundException if no thesis with the given ID is found
     */
    private ThesisEntity fetchThesisById(long thesisId) {
        return thesisRepository.findById(thesisId)
                .orElseThrow(() -> new ResourceNotFoundException("Thesis with id " + thesisId + " was not found in the database."));
    }

    /**
     * Private method that adding DTOs with data from different tables.
     *
     * @param thesisDTO    DTO with added information
     * @param thesisEntity Entity with ids of all requested data
     * @return DTO with all information
     */
    private ThesisDTO fillThesisWithDTOs(ThesisDTO thesisDTO, ThesisEntity thesisEntity) {

        thesisDTO.setStudent(personService.getPersonById(thesisEntity.getStudent().getId()));
        thesisDTO.setTrainer(personService.getPersonById(thesisEntity.getTrainer().getId()));
        thesisDTO.setConsultant(personService.getPersonById(thesisEntity.getConsultant().getId()));
        thesisDTO.setFaculty(facultyService.getFacultyById(thesisEntity.getFaculty().getId()));
        thesisDTO.setCouncil(councilService.getCouncilById(thesisEntity.getCouncil().getId()));

        return thesisDTO;
    }


}

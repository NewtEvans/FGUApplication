package cz.newtworks.FGUApplication.service;

import cz.newtworks.FGUApplication.dto.ThesisDTO;
import cz.newtworks.FGUApplication.dto.filter.ThesisFilterDTO;
import cz.newtworks.FGUApplication.dto.mapper.PersonMapper;
import cz.newtworks.FGUApplication.dto.mapper.ThesisMapper;
import cz.newtworks.FGUApplication.entity.CouncilEntity;
import cz.newtworks.FGUApplication.entity.FacultyEntity;
import cz.newtworks.FGUApplication.entity.PersonEntity;
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
    public ThesisDTO createThesis(ThesisDTO thesisDTO) {
        ThesisEntity entity = createFillEntity(thesisDTO);
        thesisRepository.save(entity);
        return thesisMapper.toDTO(entity);
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
    public int countTheses() {
        return thesisRepository.countAllThesis();
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
     * Private method that adds DTOs with data from different tables.
     *
     * @param thesisDTO DTO with added information
     * @return DTO with all information
     */
    private ThesisEntity createFillEntity(ThesisDTO thesisDTO) {
        ThesisEntity filledThesisEntity = thesisMapper.toEntity(thesisDTO);

        if (thesisDTO.getStudent().getId() != null) {
            PersonEntity student = personRepository.findById(thesisDTO.getStudent().getId())
                    .orElseThrow(() -> new ResourceNotFoundException("Student with id " + filledThesisEntity.getStudent().getId() + " wasn't found in the database."));
            filledThesisEntity.setStudent(student);
        } else filledThesisEntity.setStudent(null);

        if (thesisDTO.getTrainer().getId() != null) {
            PersonEntity trainer = personRepository.findById(thesisDTO.getTrainer().getId())
                    .orElseThrow(() -> new ResourceNotFoundException("Trainer with id " + filledThesisEntity.getTrainer().getId() + " wasn't found in the database."));
            filledThesisEntity.setTrainer(trainer);
        } else filledThesisEntity.setTrainer(null);

        if (thesisDTO.getConsultant().getId() != null) {
            PersonEntity consultant = personRepository.findById(thesisDTO.getConsultant().getId())
                    .orElseThrow(() -> new ResourceNotFoundException("Consultant with id " + filledThesisEntity.getConsultant().getId() + " wasn't found in the database."));
            filledThesisEntity.setConsultant(consultant);
        } else filledThesisEntity.setConsultant(null);

        if (thesisDTO.getCouncil().getId() != null) {
            CouncilEntity council = councilRepository.findById(thesisDTO.getCouncil().getId())
                    .orElseThrow(() -> new ResourceNotFoundException("Council with id " + filledThesisEntity.getCouncil().getId() + " wasn't found in the database."));
            filledThesisEntity.setCouncil(council);
        } else filledThesisEntity.setCouncil(null);

        if (thesisDTO.getFaculty().getId() != null) {
            FacultyEntity faculty = facultyRepository.findById(thesisDTO.getFaculty().getId())
                    .orElseThrow(() -> new ResourceNotFoundException("Faculty with id " + filledThesisEntity.getFaculty().getId() + " wasn't found in the database."));
            filledThesisEntity.setFaculty(faculty);
        } else filledThesisEntity.setFaculty(null);


        return filledThesisEntity;
    }


}

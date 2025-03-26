package cz.newtworks.FGUApplication.service;

import cz.newtworks.FGUApplication.dto.ThesisDTO;
import cz.newtworks.FGUApplication.dto.mapper.PersonMapper;
import cz.newtworks.FGUApplication.dto.mapper.ThesisMapper;
import cz.newtworks.FGUApplication.entity.ThesisEntity;
import cz.newtworks.FGUApplication.entity.repository.PersonRepository;
import cz.newtworks.FGUApplication.entity.repository.ThesisRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ThesisServiceImpl implements ThesisService{

    @Autowired
    private ThesisRepository thesisRepository;

    @Autowired
    private ThesisMapper thesisMapper;

    @Autowired
    private PersonService personService;

    @Autowired
    private PersonMapper personMapper;

    @Autowired
    private FacultyService facultyService;

    @Autowired
    private CouncilService councilService;

    @Override
    public ThesisDTO addThesis(ThesisDTO thesisDTO) {

        ThesisEntity entity = thesisMapper.toEntity(thesisDTO);
        thesisRepository.save(entity);

        return fillThesisWithDTOs(thesisMapper.toDTO(entity), entity);


    }

    @Override
    public ThesisDTO detailThesis(long thesisId) {
        return thesisMapper.toDTO(fetchThesisById(thesisId));
    }

    @Override
    public List<ThesisDTO> getAllThesis() {
       return thesisRepository.findAll()
                .stream()
                .map(i -> thesisMapper.toDTO(i))
                .collect(Collectors.toList());
    }

    @Override
    public ThesisDTO editThesis(long thesisId, ThesisDTO thesisDTO) {
        return null;
    }

    //Private methods
    private ThesisEntity fetchThesisById(long thesisId){
        return thesisRepository.findById(thesisId)
                .orElseThrow(() -> new EntityNotFoundException("Thesis with id " + thesisId + " was not found in the database."));
    }

    private ThesisDTO fillThesisWithDTOs(ThesisDTO thesisDTO, ThesisEntity thesisEntity){

        thesisDTO.setStudent(personService.personDetail(thesisEntity.getStudent().getId()));
        thesisDTO.setTrainer(personService.personDetail(thesisEntity.getTrainer().getId()));
        thesisDTO.setConsultant(personService.personDetail(thesisEntity.getConsultant().getId()));
        thesisDTO.setFaculty(facultyService.facultyDetail(thesisEntity.getFaculty().getId()));
        thesisDTO.setCouncil(councilService.councilDetail(thesisEntity.getCouncil().getId()));

        return thesisDTO;
    }


}

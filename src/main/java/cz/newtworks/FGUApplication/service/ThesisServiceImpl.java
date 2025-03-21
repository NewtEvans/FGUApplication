package cz.newtworks.FGUApplication.service;

import cz.newtworks.FGUApplication.dto.ThesisDTO;
import cz.newtworks.FGUApplication.dto.mapper.ThesisMapper;
import cz.newtworks.FGUApplication.entity.ThesisEntity;
import cz.newtworks.FGUApplication.entity.repository.ThesisRepository;
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

    @Override
    public ThesisDTO addThesis(ThesisDTO thesisDTO) {

        ThesisEntity entity = thesisMapper.toEntity(thesisDTO);

        thesisRepository.save(entity);

        return thesisMapper.toDTO(entity);
    }

    @Override
    public ThesisDTO detailThesis(long thesisId) {
        return thesisMapper.toDTO(thesisRepository.findById(thesisId).get());
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
}

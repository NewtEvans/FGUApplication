package cz.newtworks.FGUApplication.service;

import cz.newtworks.FGUApplication.dto.ThesisDTO;
import cz.newtworks.FGUApplication.dto.mapper.ThesisMapper;
import cz.newtworks.FGUApplication.entity.ThesisEntity;
import cz.newtworks.FGUApplication.entity.repository.ThesisRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
}

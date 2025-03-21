package cz.newtworks.FGUApplication.service;

import cz.newtworks.FGUApplication.dto.FacultyDTO;
import cz.newtworks.FGUApplication.dto.mapper.FacultyMapper;
import cz.newtworks.FGUApplication.entity.FacultyEntity;
import cz.newtworks.FGUApplication.entity.repository.FacultyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FacultyServiceImpl implements FacultyService{

    @Autowired
    private FacultyMapper facultyMapper;

    @Autowired
    private FacultyRepository facultyRepository;

    @Override
    public FacultyDTO addFaculty(FacultyDTO facultyDTO) {

        FacultyEntity facultyEntity = facultyMapper.toEntity(facultyDTO);
        facultyRepository.save(facultyEntity);

        return facultyMapper.toDTO(facultyEntity);
    }
}

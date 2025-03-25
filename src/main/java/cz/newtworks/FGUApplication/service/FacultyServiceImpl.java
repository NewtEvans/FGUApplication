package cz.newtworks.FGUApplication.service;

import cz.newtworks.FGUApplication.dto.FacultyDTO;
import cz.newtworks.FGUApplication.dto.mapper.FacultyMapper;
import cz.newtworks.FGUApplication.entity.FacultyEntity;
import cz.newtworks.FGUApplication.entity.repository.FacultyRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

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

    @Override
    public List<FacultyDTO> getAllFaculty() {
        return facultyRepository.findAll()
                .stream()
                .map(i -> facultyMapper.toDTO(i))
                .collect(Collectors.toList());
    }

    @Override
    public FacultyDTO facultyDetail(long facultyId) {
        return facultyMapper.toDTO(fetchFacultyById(facultyId));
    }

    @Override
    public void deleteFaculty(long facultyId) {
        facultyRepository.delete(fetchFacultyById(facultyId));
    }

    @Override
    public FacultyDTO editFaculty(long facultyId, FacultyDTO facultyDTO) {
        FacultyEntity faculty = facultyMapper.toEntity(facultyDTO);
        faculty.setId(facultyId);
        facultyRepository.save(faculty);

        return facultyMapper.toDTO(fetchFacultyById(facultyId));
    }

    //Private methods

    /**
     * Private method that returns faculty entity with specific ID.
     * If asked ID doesn't exist method returns error exception.
     * @param facultyId
     * @return Faculty entity with asked id
     */
    private FacultyEntity fetchFacultyById(long facultyId){
        return facultyRepository.findById(facultyId)
                .orElseThrow(() -> new EntityNotFoundException("Faculty with id " + facultyId + " was not found in the database."));
    }
}

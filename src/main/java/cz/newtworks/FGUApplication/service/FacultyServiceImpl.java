package cz.newtworks.FGUApplication.service;

import cz.newtworks.FGUApplication.dto.FacultyDTO;
import cz.newtworks.FGUApplication.dto.filter.FacultyFilterDTO;
import cz.newtworks.FGUApplication.dto.mapper.FacultyMapper;
import cz.newtworks.FGUApplication.entity.FacultyEntity;
import cz.newtworks.FGUApplication.entity.repository.FacultyRepository;
import cz.newtworks.FGUApplication.exception.ResourceNotFoundException;
import cz.newtworks.FGUApplication.specification.FacultySpecification;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

@Service
public class FacultyServiceImpl implements FacultyService {

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
    public Page<FacultyDTO> getAllFaculty(Pageable pageable, FacultyFilterDTO facultyFilterDTO) {
        Specification<FacultyEntity> specification = FacultySpecification.buildSpecification(facultyFilterDTO);

        return facultyRepository.findAll(specification, pageable)
                .map(facultyMapper::toDTO);
    }

    @Override
    public FacultyDTO getFacultyById(long facultyId) {
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
     *
     * @param facultyId
     * @return Faculty entity with asked id
     * @throws ResourceNotFoundException if no person with the given ID is found
     */
    private FacultyEntity fetchFacultyById(long facultyId) {
        return facultyRepository.findById(facultyId)
                .orElseThrow(() -> new ResourceNotFoundException("Faculty with id " + facultyId + " was not found in the database."));
    }
}

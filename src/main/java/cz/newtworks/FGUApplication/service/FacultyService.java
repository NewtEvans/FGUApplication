package cz.newtworks.FGUApplication.service;

import cz.newtworks.FGUApplication.dto.FacultyDTO;

import java.util.List;

public interface FacultyService {

    FacultyDTO addFaculty(FacultyDTO facultyDTO);

    List<FacultyDTO> getAllFaculty();

    FacultyDTO facultyDetail(long facultyId);

    void deleteFaculty(long facultyId);

}

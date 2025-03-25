package cz.newtworks.FGUApplication.service;

import cz.newtworks.FGUApplication.dto.FacultyDTO;

import java.util.List;

public interface FacultyService {

    /**
     * Method creates a new faculty into the database.
     * @param facultyDTO
     * @return DTO with freshly created faculty
     */
    FacultyDTO addFaculty(FacultyDTO facultyDTO);

    /**
     * Method returns list with all faculties in the database.
     * @return List of all faculties in the database
     */
    List<FacultyDTO> getAllFaculty();

    /**
     * Method returns details of faculty with requested id.
     * @param facultyId Requested id
     * @return DTO with detail of faculty with requested id
     */
    FacultyDTO facultyDetail(long facultyId);

    /**
     * Method edits already created faculty.
     * @param facultyId id of edited faculty
     * @param facultyDTO new faculty data
     * @return DTO with updated faculty
     */
    FacultyDTO editFaculty(long facultyId, FacultyDTO facultyDTO);

    /**
     * Method deletes faculty with requested id.
     * @param facultyId id of faculty to delete
     */
    void deleteFaculty(long facultyId);

}

package com.marian.university.mapper;

import com.marian.university.dto.StudentDetailsDTO;
import com.marian.university.entity.StudentDetails;
import com.marian.university.repository.StudentsDetailRepository;
import org.springframework.beans.factory.annotation.Autowired;

public class StudentDetailMapper {
    @Autowired
    private StudentsDetailRepository studentsDetailRepository;

    public StudentDetailsDTO studentDetailsToDto(StudentDetails studentDetails){
        StudentDetailsDTO studentDetailsDTO = new StudentDetailsDTO();

        studentDetailsDTO.setUserId(studentsDetailRepository.getOne(studentDetails.getId()).getUser().getId());
        studentDetailsDTO.setId(studentDetails.getId());
//        studentDetailsDTO.s

return  studentDetailsDTO;
    }
    public StudentDetails dtoToStudentDetails(StudentDetailsDTO dto){
        StudentDetails studentDetails = new StudentDetails();
        studentDetails.setId(dto.getId());

        studentDetails.setUser(studentsDetailRepository.getOne(dto.getId()).getUser());


    return  studentDetails;
    }
}

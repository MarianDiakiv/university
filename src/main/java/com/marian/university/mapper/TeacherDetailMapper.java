package com.marian.university.mapper;

import com.marian.university.dto.TeacherDetailsDTO;
import com.marian.university.entity.TeacherDetail;
import com.marian.university.repository.TeacherDetailRepository;
import org.springframework.beans.factory.annotation.Autowired;

public class TeacherDetailMapper {
    @Autowired
    private TeacherDetailRepository teacherDetailRepository;

    public TeacherDetailsDTO teacherDetailToDto(TeacherDetail teacherDetail){
        TeacherDetailsDTO dto = new TeacherDetailsDTO();
        dto.setId(teacherDetail.getId());
        dto.setUserId(teacherDetail.getUser().getId());
        return dto;
    }
    public TeacherDetail dtoToTeacherDetail(TeacherDetailsDTO dto){
        TeacherDetail teacherDetail = new TeacherDetail();
        teacherDetail.setId(dto.getId());
        TeacherDetail detail = teacherDetailRepository.getOne(dto.getId());
        if(detail!=null){
            teacherDetail.setUser(detail.getUser());
            teacherDetail.setTimeList(detail.getTimeList());
            teacherDetail.setLessonList(detail.getLessonList());
            teacherDetail.setTeacherLessonPrices(detail.getTeacherLessonPrices());
        }
        return teacherDetail;
    }
}
